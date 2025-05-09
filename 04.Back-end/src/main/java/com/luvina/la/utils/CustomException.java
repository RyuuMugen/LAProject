package com.luvina.la.utils;

/**
 * Lớp CustomException xử lý ngoại lệ tùy chỉnh.
 *
 * @author PhamToanThang
 */
public class CustomException extends RuntimeException {
    private String code;

    /**
     * Constructor của CustomException.
     *
     * @param code Mã lỗi
     * @param message Thông báo lỗi
     */
    public CustomException(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Lấy mã lỗi.
     *
     * @return Mã lỗi
     */
    public String getCode() {
        return code;
    }
}
