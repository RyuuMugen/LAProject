/**
 * File: EmployeeMapper.java
 * Package: com.luvina.la.mapper
 * Description: Lớp mapper để ánh xạ dữ liệu từ native query (Object[]) sang đối tượng EmployeeDTO.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeMapper.java, 05/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.mapper;

import com.luvina.la.dto.EmployeeDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Lớp tiện ích để chuyển đổi dữ liệu từ kết quả native query (Object[])
 * sang đối tượng {@link EmployeeDTO}.
 */
public class EmployeeMapper {

    /** Định dạng ngày mặc định: yyyy-MM-dd. */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * Chuyển đổi một dòng kết quả truy vấn (Object[]) thành đối tượng EmployeeDTO.
     *
     * @param row Dữ liệu từ native query dưới dạng Object[]
     * @return Đối tượng {@link EmployeeDTO} chứa thông tin nhân viên và chứng chỉ, hoặc null nếu dữ liệu không hợp lệ
     */
    public static EmployeeDTO mapToDTO(Object[] row) {
        if (row == null || row.length < 9) {
            return null;
        }

        Long employeeId = row[0] != null ? ((Number) row[0]).longValue() : null;
        String employeeName = row[1] != null ? row[1].toString() : null;
        String birthDate = row[2] != null ? formatDate(row[2]) : null;
        String departmentName = row[3] != null ? row[3].toString() : null;
        String email = row[4] != null ? row[4].toString() : null;
        String telephone = row[5] != null ? row[5].toString() : null;
        String certificationName = row[6] != null ? row[6].toString() : null;
        String endDate = row[7] != null ? formatDate(row[7]) : null;
        String score = row[8] != null ? row[8].toString() : null;

        return new EmployeeDTO(
                employeeId,
                employeeName,
                birthDate,
                departmentName,
                email,
                telephone,
                certificationName,
                endDate,
                score
        );
    }

    /**
     * Định dạng đối tượng ngày thành chuỗi theo định dạng yyyy-MM-dd.
     *
     * @param dateObj Đối tượng ngày (có thể là java.sql.Date hoặc java.time.LocalDate)
     * @return Chuỗi định dạng ngày, hoặc chuỗi toString() nếu không xác định được kiểu
     */
    private static String formatDate(Object dateObj) {
        if (dateObj instanceof java.sql.Date) {
            return ((java.sql.Date) dateObj).toLocalDate().format(DATE_FORMATTER);
        } else if (dateObj instanceof LocalDate) {
            return ((LocalDate) dateObj).format(DATE_FORMATTER);
        } else {
            return dateObj.toString();
        }
    }
}
