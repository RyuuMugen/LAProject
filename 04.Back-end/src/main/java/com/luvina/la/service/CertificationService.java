package com.luvina.la.service;

import java.util.Map;

/**
 * Interface dịch vụ để lấy danh sách các tín chỉ.
 *
 * @author PhamToanThang
 */
public interface CertificationService {
    /**
     * Lấy danh sách tín chỉ.
     *
     * @return Map chứa mã phản hồi, danh sách tín chỉ.
     */
    Map<String, Object> getAllCertifications();
}
