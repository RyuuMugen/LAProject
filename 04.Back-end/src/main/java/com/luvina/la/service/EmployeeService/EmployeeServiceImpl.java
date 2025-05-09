/**
 * File: EmployeeServiceImpl.java
 * Package: com.luvina.la.service.EmployeeService
 * Description: Class triển khai dịch vụ xử lý logic liên quan đến nhân viên.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeServiceImpl.java, 05/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.service.EmployeeService;

import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.mapper.EmployeeMapper;
import com.luvina.la.repository.EmployeeRepository;
import com.luvina.la.utils.CustomException;
import com.luvina.la.utils.MessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lớp thực thi nghiệp vụ lấy danh sách nhân viên với phân trang, lọc và sắp xếp động.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Lấy danh sách nhân viên theo tiêu chí lọc, phân trang và sắp xếp động.
     *
     * @param offset               Vị trí bắt đầu lấy bản ghi
     * @param limit                Số lượng bản ghi cần lấy
     * @param employeeName         Tên nhân viên (tìm gần đúng)
     * @param departmentId         Mã phòng ban
     * @param ordEmployeeName      Sắp xếp theo tên nhân viên (ASC/DESC/null)
     * @param ordCertificationName Sắp xếp theo tên chứng chỉ (ASC/DESC/null)
     * @param ordEndDate           Sắp xếp theo ngày hết hạn chứng chỉ (ASC/DESC/null)
     * @return Map chứa danh sách nhân viên, tổng số bản ghi, mã phản hồi
     * @throws CustomException Nếu dữ liệu đầu vào không hợp lệ
     */
    @Override
    public Map<String, Object> getEmployees(
            Integer offset,
            Integer limit,
            String employeeName,
            Long departmentId,
            String ordEmployeeName,
            String ordCertificationName,
            String ordEndDate,
            String sortPriority) throws CustomException {

        // Kiểm tra offset và limit
        if (offset == null || offset < 0) {
            throw new CustomException("ER018", MessageUtil.getMessage("ER018").replace("{0}", "オフセット"));
        }

        if (limit == null || limit <= 0) {
            throw new CustomException("ER018", MessageUtil.getMessage("ER018").replace("{0}", "リミット"));
        }

        // Kiểm tra thứ tự sắp xếp hợp lệ
        List<String> validOrders = List.of("ASC", "DESC");
        ordEmployeeName = validateOrder(ordEmployeeName, validOrders);
        ordCertificationName = validateOrder(ordCertificationName, validOrders);
        ordEndDate = validateOrder(ordEndDate, validOrders);

        // Đếm tổng số bản ghi
        Long totalRecords = employeeRepository.countEmployees(employeeName, departmentId);

        // Chuẩn bị map trả về
        Map<String, Object> response = new HashMap<>();
        response.put("code", "200");
        response.put("totalRecords", totalRecords);

        // Nếu có bản ghi thì mới truy vấn dữ liệu
        if (totalRecords > 0) {
            List<Object[]> results = employeeRepository.findEmployeesWithDynamicSorting(
                    employeeName,
                    departmentId,
                    ordEmployeeName,
                    ordCertificationName,
                    ordEndDate,
                    sortPriority,
                    limit,
                    offset
            );

            List<EmployeeDTO> employees = results.stream()
                    .map(EmployeeMapper::mapToDTO)
                    .collect(Collectors.toList());

            response.put("employees", employees);
        } else {
             response.put("employees", List.of()); // Trả về list rỗng
        }
        return response;
    }

    /**
     * Hàm kiểm tra và chuẩn hóa thứ tự sắp xếp (ASC/DESC).
     *
     * @param orderParam Chuỗi order từ client
     * @param validOrders Danh sách các thứ tự hợp lệ
     * @return Chuỗi order hợp lệ viết hoa hoặc null
     * @throws CustomException Nếu giá trị không hợp lệ
     */
    private String validateOrder(String orderParam, List<String> validOrders) throws CustomException {
        if (orderParam == null) {
            return null;
        }

        String upper = orderParam.toUpperCase();

        if (!validOrders.contains(upper)) {
            throw new CustomException("ER021", MessageUtil.getMessage("ER021"));
        }

        return upper;
    }
}
