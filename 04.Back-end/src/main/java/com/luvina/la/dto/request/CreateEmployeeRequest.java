package com.luvina.la.dto;

import com.luvina.la.dto.request.CreateEmployeeCertificationRequest;

import java.util.Collections;
import java.util.List;

/**
 * Lớp DTO dùng để truyền dữ liệu tạo mới nhân viên.
 */
public class CreateEmployeeRequest {

    /** Tên nhân viên */
    private String employeeName;

    /** Ngày sinh nhân viên (định dạng chuỗi) */
    private String employeeBirthDate;

    /** Tên phòng ban của nhân viên */
    private String departmentName;

    /** Email nhân viên */
    private String employeeEmail;

    /** Số điện thoại nhân viên */
    private String employeeTelephone;

    /** Mật khẩu của nhân viên */
    private String employeePassword;

    /** Danh sách chứng chỉ của nhân viên (Có thể rỗng) */
    private List<CreateEmployeeCertificationRequest> certifications;

    /**
     * Constructor đầy đủ tham số để khởi tạo đối tượng CreateEmployeeRequest.
     *
     * @param employeeName     Tên nhân viên
     * @param employeeBirthDate Ngày sinh nhân viên
     * @param departmentName   Tên phòng ban
     * @param employeeEmail    Email nhân viên
     * @param employeeTelephone Số điện thoại nhân viên
     * @param employeePassword Mật khẩu nhân viên
     * @param certifications    Danh sách chứng chỉ (Có thể rỗng)
     */
    public CreateEmployeeRequest(String employeeName, String employeeBirthDate, String departmentName,
                                 String employeeEmail, String employeeTelephone, String employeePassword,
                                 List<CreateEmployeeCertificationRequest> certifications) {
        this.employeeName = employeeName;
        this.employeeBirthDate = employeeBirthDate;
        this.departmentName = departmentName;
        this.employeeEmail = employeeEmail;
        this.employeeTelephone = employeeTelephone;
        this.employeePassword = employeePassword;
        this.certifications = certifications != null ? certifications : Collections.emptyList(); // Nếu null, khởi tạo danh sách rỗng
    }

    // Getters and Setters...

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    public void setEmployeeBirthDate(String employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeTelephone() {
        return employeeTelephone;
    }

    public void setEmployeeTelephone(String employeeTelephone) {
        this.employeeTelephone = employeeTelephone;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public List<CreateEmployeeCertificationRequest> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<CreateEmployeeCertificationRequest> certifications) {
        this.certifications = certifications != null ? certifications : Collections.emptyList(); // Đảm bảo không null
    }
}
