package com.luvina.la.controller;

import com.luvina.la.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeController.java, 03/05/2025, 16_PhamToanThang
 *
 * Controller xử lý các yêu cầu HTTP liên quan đến danh sách nhân viên.
 * Cung cấp API để lấy danh sách nhân viên có phân trang, lọc và sắp xếp.
 * Mọi ngoại lệ tùy chỉnh được xử lý bởi GlobalExceptionHandler.
 *
 * @author PhamToanThang
 */
@RestController
public class EmployeeController {

    /** Service xử lý nghiệp vụ liên quan đến danh sách nhân viên. */
    @Autowired
    private EmployeeService employeeService;

    /**
     * API trả về danh sách nhân viên với phân trang, lọc và sắp xếp theo yêu cầu.
     *
     * @param offset               Vị trí bắt đầu của kết quả (default = 0).
     * @param limit                Số lượng bản ghi mỗi trang (default = 5).
     * @param employeeName         Tên nhân viên cần tìm (tùy chọn).
     * @param departmentId         ID của phòng ban (tùy chọn).
     * @param ordEmployeeName      Thứ tự sắp xếp tên nhân viên (ASC | DESC, tùy chọn).
     * @param ordCertificationName Thứ tự sắp xếp tên chứng chỉ (ASC | DESC, tùy chọn).
     * @param ordEndDate           Thứ tự sắp xếp ngày hết hạn chứng chỉ (ASC | DESC, tùy chọn).
     * @param sortPriority         Trường ưu tiên sắp xếp đầu tiên (ord_employee_name | ord_certification_name | ord_end_date)
     * @return Đối tượng ResponseEntity chứa danh sách nhân viên.
     */
    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> list(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(required = false) String employeeName,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(name = "ord_employee_name", required = false) String ordEmployeeName,
            @RequestParam(name = "ord_certification_name", required = false) String ordCertificationName,
            @RequestParam(name = "ord_end_date", required = false) String ordEndDate,
            @RequestParam(name = "sortPriority", required = false) String sortPriority
    ) {
        // Reset các field không được ưu tiên
        if (sortPriority != null) {
            if (!sortPriority.equals("ord_employee_name")) {
                ordEmployeeName = null;
            }
            if (!sortPriority.equals("ord_certification_name")) {
                ordCertificationName = null;
            }
            if (!sortPriority.equals("ord_end_date")) {
                ordEndDate = null;
            }
        }

        Map<String, Object> result = employeeService.getEmployees(
                offset, limit, employeeName, departmentId,
                ordEmployeeName, ordCertificationName, ordEndDate, sortPriority
        );

        return ResponseEntity.ok(result);
    }
}
