package com.luvina.la.utils;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * Copyright(C) 2025 Luvina Software Company
 * MessageUtil.java, 24/04/2025 16_PhamToanThang
 *
 * Lớp tiện ích cho việc xử lý thông điệp quốc tế hóa và mã lỗi.
 * Hỗ trợ tải thông điệp dựa trên ngôn ngữ từ file cấu hình duy nhất.
 */
public class MessageUtil {

    /** Locale cho ngôn ngữ hiện tại */
    private static String lang;

    /** Properties chứa toàn bộ thông điệp */
    private static Properties props = new Properties();

    static {
        lang = getLocaleFromProperties();  // Lấy locale từ file config
        loadMessages();                    // Nạp toàn bộ thông điệp
    }

    /**
     * Trả về thông điệp theo mã code và ngôn ngữ hiện tại.
     *
     * @param code Mã thông điệp (VD: ER001, MSG001)
     * @return Thông điệp theo ngôn ngữ, hoặc chính mã code nếu không có
     */
    public static String getMessage(String code) {
        String key = code + "." + lang;
        return props.getProperty(key, code);
    }

    /**
     * Thiết lập lại ngôn ngữ ứng dụng.
     *
     * @param newLang "vi" hoặc "ja"
     */
    public static void setLocale(String newLang) {
        lang = newLang;
    }

    /**
     * Đọc locale từ file error_and_message_codes.properties
     */
    private static String getLocaleFromProperties() {
        try (InputStream input = MessageUtil.class.getClassLoader()
                .getResourceAsStream("error_and_message_codes.properties")) {
            Properties config = new Properties();
            if (input == null) {
                System.out.println("Không tìm thấy file error_and_message_codes.properties");
                return "vi";
            }
            config.load(input);
            return config.getProperty("locale", "vi");
        } catch (Exception e) {
            e.printStackTrace();
            return "vi";
        }
    }

    /**
     * Nạp toàn bộ messages từ file error_and_message_codes.properties
     */
    private static void loadMessages() {
        try (InputStream input = MessageUtil.class.getClassLoader()
                .getResourceAsStream("error_and_message_codes.properties")) {
            if (input != null) {
                props.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
