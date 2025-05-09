/**
 * File: EmployeeDTO.java
 * Package: com.luvina.la.dto
 * Description: Lớp DTO dùng để truyền dữ liệu danh sách nhân viên và chứng chỉ tương ứng.
 *
 * Copyright(C) 2025 Luvina Software Company
 * EmployeeDTO.java, 03/05/2025, 16_PhamToanThang
 *
 * @author PhamToanThang
 */

package com.luvina.la.dto;

/**
 * Lớp đại diện cho thông tin nhân viên kèm chứng chỉ tương ứng.
 */
public class EmployeeDTO {

    /** ID của nhân viên. */
    private Long employeeId;

    /** Tên của nhân viên. */
    private String employeeName;

    /** Ngày sinh của nhân viên (định dạng chuỗi). */
    private String employeeBirthDate;

    /** Tên phòng ban của nhân viên. */
    private String departmentName;

    /** Email của nhân viên. */
    private String employeeEmail;

    /** Số điện thoại của nhân viên. */
    private String employeeTelephone;

    /** Tên chứng chỉ mà nhân viên sở hữu. */
    private String certificationName;

    /** Ngày hết hạn của chứng chỉ. */
    private String endDate;

    /** Điểm số tương ứng với chứng chỉ. */
    private String score;

    /**
     * Constructor đầy đủ tham số để khởi tạo một đối tượng EmployeeDTO.
     *
     * @param employeeId         ID nhân viên
     * @param employeeName       Tên nhân viên
     * @param employeeBirthDate  Ngày sinh nhân viên
     * @param departmentName     Tên phòng ban
     * @param employeeEmail      Email
     * @param employeeTelephone  Số điện thoại
     * @param certificationName  Tên chứng chỉ
     * @param endDate            Ngày hết hạn chứng chỉ
     * @param score              Điểm số chứng chỉ
     */
    public EmployeeDTO(Long employeeId, String employeeName, String employeeBirthDate,
                       String departmentName, String employeeEmail, String employeeTelephone,
                       String certificationName, String endDate, String score) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthDate = employeeBirthDate;
        this.departmentName = departmentName;
        this.employeeEmail = employeeEmail;
        this.employeeTelephone = employeeTelephone;
        this.certificationName = certificationName;
        this.endDate = endDate;
        this.score = score;
    }

    /** @return ID nhân viên */
    public Long getEmployeeId() {
        return employeeId;
    }

    /** @param employeeId ID nhân viên */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /** @return Tên nhân viên */
    public String getEmployeeName() {
        return employeeName;
    }

    /** @param employeeName Tên nhân viên */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /** @return Ngày sinh nhân viên */
    public String getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    /** @param employeeBirthDate Ngày sinh nhân viên */
    public void setEmployeeBirthDate(String employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    /** @return Tên phòng ban */
    public String getDepartmentName() {
        return departmentName;
    }

    /** @param departmentName Tên phòng ban */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /** @return Email nhân viên */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /** @param employeeEmail Email nhân viên */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    /** @return Số điện thoại nhân viên */
    public String getEmployeeTelephone() {
        return employeeTelephone;
    }

    /** @param employeeTelephone Số điện thoại nhân viên */
    public void setEmployeeTelephone(String employeeTelephone) {
        this.employeeTelephone = employeeTelephone;
    }

    /** @return Tên chứng chỉ */
    public String getCertificationName() {
        return certificationName;
    }

    /** @param certificationName Tên chứng chỉ */
    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    /** @return Ngày hết hạn chứng chỉ */
    public String getEndDate() {
        return endDate;
    }

    /** @param endDate Ngày hết hạn chứng chỉ */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /** @return Điểm số chứng chỉ */
    public String getScore() {
        return score;
    }

    /** @param score Điểm số chứng chỉ */
    public void setScore(String score) {
        this.score = score;
    }
}
