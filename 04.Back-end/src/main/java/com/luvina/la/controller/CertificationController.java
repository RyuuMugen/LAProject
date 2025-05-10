package com.luvina.la.controller;

import com.luvina.la.service.CertificationService;
import com.luvina.la.service.DepartmentService;
import com.luvina.la.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller để xử lý các yêu cầu liên quan đến chứng chỉ.
 * Cung cấp các API để lấy danh sách chứng chỉ và xử lý lỗi.
 *
 * @author PhamToanThang
 */
@RestController
public class CertificationController {
    /** Dịch vụ chứng chỉ */
    @Autowired
    private CertificationService certificationService;

    /**
     * API lấy danh sách chứng chỉ.
     *
     * @param locale Ngôn ngữ yêu cầu (ví dụ: "vi", "ja"). Mặc định là "vi".
     * @return ResponseEntity chứa dữ liệu chứng chỉ hoặc thông báo lỗi nếu có lỗi xảy ra.
     */
    @GetMapping("/certifications")
    public ResponseEntity<Map<String, Object>> getCertifications(@RequestHeader(value = "Accept-Language", defaultValue = "vi") String locale) {
        // Thiết lập locale cho MessageUtil
        MessageUtil.setLocale(locale);

        // Lấy danh sách chứng chỉ từ dịch vụ (dữ liệu trả về dưới dạng Map)
        Map<String, Object> responseMap = certificationService.getAllCertifications();

        // Trả về Map trực tiếp trong ResponseEntity
        return ResponseEntity.ok(responseMap);
    }
}
