package com.luvina.la.service.EmployeeService;

import com.luvina.la.utils.CustomException;
import java.util.Map;

/**
 * Interface dịch vụ để lấy danh sách nhân viên.
 *
 * @author PhamToanThang
 */
public interface EmployeeService {

    /**
     * Lấy danh sách nhân viên theo các tham số tìm kiếm.
     *
     * @param offset Số lượng nhân viên bắt đầu lấy (dùng để phân trang).
     * @param limit Số lượng nhân viên tối đa trả về.
     * @param employeeName Tên nhân viên (nếu có).
     * @param departmentId ID của phòng ban (nếu có).
     * @param ord_employee_name Thứ tự sắp xếp theo tên nhân viên.
     * @param ord_certification_name Thứ tự sắp xếp theo tên chứng chỉ.
     * @param ord_end_date Thứ tự sắp xếp theo ngày hết hạn chứng chỉ.
     *
     * @return Map chứa thông tin danh sách nhân viên và các thông tin phân trang.
     * @throws CustomException Nếu có lỗi xảy ra trong quá trình lấy dữ liệu.
     */
    Map<String, Object> getEmployees(
            Integer offset,
            Integer limit,
            String employeeName,
            Long departmentId,
            String ord_employee_name,
            String ord_certification_name,
            String ord_end_date,
            String sortPriority
    ) throws CustomException;
}
