package com.luvina.la.repository;

import com.luvina.la.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository để xử lý các thao tác với entity Department.
 * Cung cấp các phương thức để truy vấn và thao tác với bảng phòng ban trong cơ sở dữ liệu.
 *
 * @author PhamToanThang
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Tìm phòng ban theo tên phòng ban.
     *
     * @param departmentName Tên phòng ban cần tìm.
     * @return Department đối tượng phòng ban tìm thấy, hoặc null nếu không tìm thấy.
     */
    Department findByDepartmentName(String departmentName);
}
