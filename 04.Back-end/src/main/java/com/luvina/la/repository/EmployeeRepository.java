/**
 * File: EmployeeRepository.java
 * Package: com.luvina.la.repository
 * Description: Repository quản lý truy vấn dữ liệu nhân viên từ cơ sở dữ liệu.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeRepository.java, 05/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.repository;

import com.luvina.la.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Giao diện Repository mở rộng từ PagingAndSortingRepository để thao tác với thực thể {@link Employee}.
 * Bao gồm các phương thức phân trang, tìm kiếm và đếm nhân viên theo tiêu chí.
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, EmployeeRepositoryCustom {

    /**
     * Tìm kiếm danh sách nhân viên theo mã phòng ban và tên nhân viên (có chứa).
     *
     * @param departmentId  ID phòng ban
     * @param employeeName  Tên nhân viên cần tìm (một phần)
     * @param pageable      Đối tượng phân trang
     * @return Trang kết quả chứa danh sách nhân viên
     */
    Page<Employee> findByDepartment_DepartmentIdAndEmployeeNameContaining(
            Long departmentId, String employeeName, Pageable pageable);

    /**
     * Tìm kiếm danh sách nhân viên theo tên nhân viên (có chứa).
     *
     * @param employeeName  Tên nhân viên cần tìm (một phần)
     * @param pageable      Đối tượng phân trang
     * @return Trang kết quả chứa danh sách nhân viên
     */
    Page<Employee> findByEmployeeNameContaining(String employeeName, Pageable pageable);

    /**
     * Truy vấn tất cả nhân viên có phân trang.
     *
     * @param pageable Đối tượng phân trang
     * @return Trang kết quả chứa danh sách toàn bộ nhân viên
     */
    Page<Employee> findAll(Pageable pageable);

    /**
     * Đếm tổng số nhân viên theo bộ lọc tên và phòng ban.
     *
     * @param employeeName  Tên nhân viên cần tìm (có thể null)
     * @param departmentId  ID phòng ban (có thể null)
     * @return Tổng số nhân viên thỏa mãn điều kiện
     */
    @Query(value = """
        SELECT COUNT(*) 
        FROM employees e
        WHERE (:employeeName IS NULL OR e.employee_name LIKE %:employeeName%)
          AND (:departmentId IS NULL OR e.department_id = :departmentId)
        """, nativeQuery = true)
    Long countEmployees(
            @Param("employeeName") String employeeName,
            @Param("departmentId") Long departmentId
    );
}
