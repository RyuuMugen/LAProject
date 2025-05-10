package com.luvina.la.controller;

import com.luvina.la.service.DepartmentService;
import com.luvina.la.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller để xử lý các yêu cầu liên quan đến phòng ban.
 * Cung cấp các API để lấy danh sách phòng ban và xử lý lỗi.
 *
 * @author PhamToanThang
 */
@RestController
public class DepartmentController {

    /** Dịch vụ phòng ban */
    @Autowired
    private DepartmentService departmentService;

    /**
     * API lấy danh sách phòng ban.
     *
     * @param locale Ngôn ngữ yêu cầu (ví dụ: "vi", "ja"). Mặc định là "vi".
     * @return ResponseEntity chứa dữ liệu phòng ban hoặc thông báo lỗi nếu có lỗi xảy ra.
     */
    @GetMapping("/departments")
    public ResponseEntity<Map<String, Object>> getDepartments(@RequestHeader(value = "Accept-Language", defaultValue = "vi") String locale) {
        // Thiết lập locale cho MessageUtil
        MessageUtil.setLocale(locale);

        // Lấy danh sách phòng ban từ dịch vụ (dữ liệu trả về dưới dạng Map)
        Map<String, Object> responseMap = departmentService.getAllDepartments();

        // Trả về Map trực tiếp trong ResponseEntity
        return ResponseEntity.ok(responseMap);
    }
}
