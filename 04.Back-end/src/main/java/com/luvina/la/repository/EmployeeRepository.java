package com.luvina.la.repository;

import com.luvina.la.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Giao diện Repository mở rộng từ PagingAndSortingRepository để thao tác với thực thể {@link Employee}.
 * Bao gồm các phương thức phân trang, tìm kiếm và đếm nhân viên theo tiêu chí.
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, EmployeeRepositoryCustom {

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

    /**
     * Thêm mới một nhân viên vào cơ sở dữ liệu.
     *
     * @param employee Đối tượng nhân viên cần thêm
     * @return Đối tượng nhân viên đã được lưu
     */
    Employee save(Employee employee); // Phương thức này đã có sẵn trong PagingAndSortingRepository

}
