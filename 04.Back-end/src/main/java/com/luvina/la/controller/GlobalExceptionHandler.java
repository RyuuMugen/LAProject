package com.luvina.la.controller;

import com.luvina.la.dto.MessageDTO;
import com.luvina.la.utils.CustomException;
import com.luvina.la.utils.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global handler cho tất cả exception trong hệ thống.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Xử lý CustomException toàn cục.
     *
     * @param ex ngoại lệ được ném ra
     * @return ResponseEntity chứa mã lỗi và message
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
        // Khởi tạo responseMap để chứa mã lỗi và thông báo
        Map<String, Object> responseMap = new HashMap<>();

        // Mã lỗi HTTP là 500 (lỗi hệ thống)
        responseMap.put("code", "500");

        // Thông báo lỗi với mã lỗi chi tiết (ER018)
        MessageDTO message = new MessageDTO();
        message.setCode(ex.getCode());  // Sử dụng mã lỗi từ exception (ER018)

        // Lấy thông báo từ MessageUtil
        String msg = MessageUtil.getMessage(ex.getCode());  // Thay vì ex.getMessage()
        message.setParams(List.of(msg));  // Đặt thông báo vào params

        responseMap.put("message", message);  // Đặt thông báo lỗi vào responseMap

        // Trả về mã lỗi HTTP 500 với thông báo lỗi chi tiết
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
    }

    /**
     * Xử lý các ngoại lệ không mong muốn (general exception).
     *
     * @param ex ngoại lệ chung
     * @return ResponseEntity chứa mã lỗi và thông điệp lỗi chung
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        // Khởi tạo responseMap cho ngoại lệ không mong muốn
        Map<String, Object> responseMap = new HashMap<>();

        // Mã lỗi HTTP là 500 cho các lỗi hệ thống
        responseMap.put("code", "500");

        // Thông báo lỗi chung
        MessageDTO message = new MessageDTO();
        message.setCode("ER500");  // Mã lỗi hệ thống chung

        // Thông báo lỗi hệ thống chung
        message.setParams(List.of("Lỗi hệ thống, vui lòng thử lại sau."));

        responseMap.put("message", message);  // Đặt thông báo lỗi vào responseMap

        // Trả về mã lỗi HTTP 500 với thông báo lỗi chung
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
    }
}
