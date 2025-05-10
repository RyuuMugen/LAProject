/**
 * File: EmployeeCertificationService.java
 * Package: com.luvina.la.service
 * Description: Giao diện cung cấp các phương thức liên quan đến nghiệp vụ chứng chỉ nhân viên.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeCertificationService.java, 10/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.service;

import com.luvina.la.entity.EmployeeCertification;

import java.util.List;

/**
 * Giao diện cung cấp các phương thức để quản lý chứng chỉ của nhân viên.
 */
public interface EmployeeCertificationService {

    /**
     * Thêm mới danh sách chứng chỉ của nhân viên.
     *
     * @param certifications Danh sách các chứng chỉ cần thêm
     */
    void addCertifications(List<EmployeeCertification> certifications);

    /**
     * Xóa tất cả chứng chỉ của nhân viên theo ID nhân viên.
     *
     * @param employeeId ID nhân viên
     */
    void deleteCertificationsByEmployeeId(Long employeeId);

    /**
     * Lấy tất cả chứng chỉ của nhân viên theo ID nhân viên.
     *
     * @param employeeId ID nhân viên
     * @return Danh sách chứng chỉ của nhân viên
     */
    List<EmployeeCertification> getCertificationsByEmployeeId(Long employeeId);
}
