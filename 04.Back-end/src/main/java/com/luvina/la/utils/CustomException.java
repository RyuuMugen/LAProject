package com.luvina.la.utils;

/**
 * Lớp CustomException xử lý ngoại lệ tùy chỉnh.
 * Được sử dụng để cung cấp thông tin chi tiết về mã lỗi và thông báo.
 *
 * @author PhamToanThang
 */
public class CustomException extends RuntimeException {
    private String code;
    private String details;  // Thêm trường lưu trữ thông tin chi tiết lỗi

    // Các mã lỗi chuẩn
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";
    public static final String INTERNAL_SERVER_ERROR = "500";

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
     * Constructor của CustomException với thông báo lỗi mặc định cho mã lỗi.
     *
     * @param code Mã lỗi
     */
    public CustomException(String code) {
        super(MessageUtil.getMessage(code));  // Sử dụng MessageUtil để lấy thông báo lỗi
        this.code = code;
    }

    /**
     * Constructor của CustomException với thông báo lỗi và chi tiết lỗi.
     *
     * @param code Mã lỗi
     * @param message Thông báo lỗi
     * @param details Thông tin chi tiết thêm về lỗi
     */
    public CustomException(String code, String message, String details) {
        super(message);
        this.code = code;
        this.details = details;
    }

    /**
     * Lấy mã lỗi.
     *
     * @return Mã lỗi
     */
    public String getCode() {
        return code;
    }

    /**
     * Lấy thông báo lỗi.
     *
     * @return Thông báo lỗi
     */
    @Override
    public String getMessage() {
        String msg = MessageUtil.getMessage(this.code);  // Lấy thông báo từ MessageUtil theo mã lỗi
        if (details != null && !details.isEmpty()) {
            return msg + " - " + details;  // Thêm chi tiết nếu có
        }
        return msg;
    }
}
