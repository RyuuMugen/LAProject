/**
 * File: EmployeeRepositoryImpl.java
 * Package: com.luvina.la.repository
 * Description: Class hiện thực truy vấn tùy chỉnh danh sách nhân viên và chứng chỉ có phân trang và sắp xếp động.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeRepositoryImpl.java, 05/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Lớp hiện thực giao diện EmployeeRepositoryCustom để truy vấn danh sách nhân viên kèm chứng chỉ.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Truy vấn danh sách nhân viên kèm chứng chỉ có sắp xếp và phân trang động.
     *
     * @param employeeName         Tên nhân viên (có thể null)
     * @param departmentId         Mã phòng ban (có thể null)
     * @param ordEmployeeName      Sắp xếp theo tên nhân viên (ASC/DESC hoặc null)
     * @param ordCertificationName Sắp xếp theo tên chứng chỉ (ASC/DESC hoặc null)
     * @param ordEndDate           Sắp xếp theo ngày hết hạn (ASC/DESC hoặc null)
     * @param sortPriority         Ưu tiên cột sắp xếp nào (nếu có)
     * @param limit                Số lượng bản ghi trên mỗi trang
     * @param offset               Vị trí bắt đầu bản ghi
     * @return Danh sách kết quả dưới dạng Object[]
     */
    @Override
    public List<Object[]> findEmployeesWithDynamicSorting(
            String employeeName,
            Long departmentId,
            String ordEmployeeName,
            String ordCertificationName,
            String ordEndDate,
            String sortPriority,
            int limit,
            int offset) {

        StringBuilder sql = new StringBuilder("""
            SELECT e.employee_id, e.employee_name, e.employee_birth_date,
                   d.department_name, e.employee_email, e.employee_telephone,
                   c.certification_name, ec.end_date, ec.score
            FROM employees e
            JOIN departments d ON e.department_id = d.department_id
            LEFT JOIN (
                SELECT ec1.*
                FROM employee_certifications ec1
                WHERE ec1.certification_id = (
                    SELECT MIN(ec2.certification_id)
                    FROM employee_certifications ec2
                    WHERE ec2.employee_id = ec1.employee_id
                    AND (ec2.end_date >= CURRENT_DATE 
                         OR ec2.end_date = (
                             SELECT MAX(ec3.end_date)
                             FROM employee_certifications ec3
                             WHERE ec3.employee_id = ec2.employee_id
                         )
                    )
                )
            ) ec ON e.employee_id = ec.employee_id
            LEFT JOIN certifications c ON ec.certification_id = c.certification_id
            WHERE (:employeeName IS NULL OR e.employee_name LIKE :employeeName ESCAPE '\\\\')
              AND (:departmentId IS NULL OR e.department_id = :departmentId)
        """);

        // Dùng LinkedHashMap để giữ thứ tự ưu tiên
        Map<String, String> allOrders = new LinkedHashMap<>();
        if (ordEmployeeName != null) allOrders.put("e.employee_name", ordEmployeeName);
        if (ordCertificationName != null) allOrders.put("c.certification_name", ordCertificationName);
        if (ordEndDate != null) allOrders.put("ec.end_date", ordEndDate);

        // Nếu có sortPriority thì đưa nó lên đầu
        if (sortPriority != null) {
            String prioritizedColumn = switch (sortPriority) {
                case "ord_employee_name"      -> "e.employee_name";
                case "ord_certification_name" -> "c.certification_name";
                case "ord_end_date"           -> "ec.end_date";
                default                       -> null;
            };

            if (prioritizedColumn != null && allOrders.containsKey(prioritizedColumn)) {
                String value = allOrders.remove(prioritizedColumn);
                LinkedHashMap<String, String> reordered = new LinkedHashMap<>();
                reordered.put(prioritizedColumn, value);
                reordered.putAll(allOrders);
                allOrders = reordered;
            }
        }

        // Ghép ORDER BY
        if (!allOrders.isEmpty()) {
            List<String> orderClauses = new ArrayList<>();
            for (var entry : allOrders.entrySet()) {
                orderClauses.add(entry.getKey() + " " + entry.getValue());
            }
            sql.append(" ORDER BY ").append(String.join(", ", orderClauses));
        } else {
            sql.append(" ORDER BY e.employee_name ASC"); // mặc định
        }

        // Phân trang
        sql.append(" LIMIT :limit OFFSET :offset");

        Query query = entityManager.createNativeQuery(sql.toString());

        // Sanitize input employeeName trước khi truyền vào LIKE
        String sanitizedName = sanitizeInputForLike(employeeName);
        query.setParameter("employeeName", sanitizedName != null ? "%" + sanitizedName + "%" : null);
        query.setParameter("departmentId", departmentId);
        query.setParameter("limit", limit);
        query.setParameter("offset", offset);

        return query.getResultList();
    }

    /**
     * Escape các ký tự đặc biệt trong truy vấn LIKE SQL.
     *
     * @param input Chuỗi đầu vào
     * @return Chuỗi đã được escape phù hợp với cú pháp LIKE và ESCAPE '\\'
     */
    private String sanitizeInputForLike(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        return input.trim()
                .replace("\\", "\\\\")  // escape dấu \ trước tiên
                .replace("%", "\\%")
                .replace("_", "\\_")
                .replace(";", "\\;")
                .replace(",", "\\,")
                .replace("/", "\\/");
    }
}
