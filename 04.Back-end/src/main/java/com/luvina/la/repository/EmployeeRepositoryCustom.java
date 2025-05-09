/**
 * File: EmployeeRepositoryCustom.java
 * Package: com.luvina.la.repository
 * Description: Interface khai báo phương thức tùy chỉnh cho truy vấn động nhân viên kèm chứng chỉ.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeRepositoryCustom.java, 05/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.repository;

import java.util.List;

/**
 * Giao diện định nghĩa các phương thức truy vấn tùy chỉnh cho thực thể Employee.
 */
public interface EmployeeRepositoryCustom {

    /**
     * Truy vấn danh sách nhân viên kèm thông tin chứng chỉ với phân trang và sắp xếp động.
     *
     * @param employeeName          Tên nhân viên cần tìm (có thể null)
     * @param departmentId          ID phòng ban cần lọc (có thể null)
     * @param ordEmployeeName       Sắp xếp theo tên nhân viên (ASC/DESC hoặc null)
     * @param ordCertificationName  Sắp xếp theo tên chứng chỉ (ASC/DESC hoặc null)
     * @param ordEndDate            Sắp xếp theo ngày hết hạn chứng chỉ (ASC/DESC hoặc null)
     * @param limit                 Số bản ghi mỗi trang
     * @param offset                Vị trí bắt đầu của trang
     * @return Danh sách kết quả dạng mảng Object[] cho mỗi bản ghi (chuyển thành DTO sau)
     */
    List<Object[]> findEmployeesWithDynamicSorting(
            String employeeName,
            Long departmentId,
            String ordEmployeeName,
            String ordCertificationName,
            String ordEndDate,
            String sortPriority,
            int limit,
            int offset
    );
}
