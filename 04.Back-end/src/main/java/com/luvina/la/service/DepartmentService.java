package com.luvina.la.service;

import java.util.Map;

/**
 * Interface dịch vụ để lấy danh sách các phòng ban.
 *
 * @author PhamToanThang
 */
public interface DepartmentService {

    /**
     * Lấy danh sách tất cả các phòng ban.
     *
     * @return Map chứa mã phản hồi và danh sách phòng ban.
     */
    Map<String, Object> getAllDepartments();
}
