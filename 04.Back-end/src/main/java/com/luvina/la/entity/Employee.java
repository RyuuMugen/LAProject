package com.luvina.la.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Lớp Entity đại diện cho bảng nhân viên (employees).
 * Bao gồm thông tin về nhân viên, phòng ban và chứng chỉ.
 *
 * @author PhamToanThang
 */
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * Mã nhân viên (ID).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * Tên nhân viên.
     */
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * Ngày sinh của nhân viên.
     */
    @Column(name = "employee_birth_date")
    private LocalDate employeeBirthDate;

    /**
     * Email của nhân viên.
     */
    @Column(name = "employee_email")
    private String employeeEmail;

    /**
     * Số điện thoại của nhân viên.
     */
    @Column(name = "employee_telephone")
    private String employeeTelephone;
    /**
     * Mã hóa salt ngẫu nhiên để kết hợp với mật khẩu.
     */
    @Column(name = "salt")
    private String salt;

    /**
     * Vai trò của nhân viên trong hệ thống (1: user, 0: admin, v.v.).
     */
    @Column(name = "role")
    private String role;
    /**
     * Phòng ban của nhân viên.
     */
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    /**
     * Danh sách chứng chỉ của nhân viên.
     */
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeCertification> certifications;

    // Getter / Setter

    /**
     * Lấy mã nhân viên.
     *
     * @return Mã nhân viên
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * Đặt mã nhân viên.
     *
     * @param employeeId Mã nhân viên
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Lấy tên nhân viên.
     *
     * @return Tên nhân viên
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Đặt tên nhân viên.
     *
     * @param employeeName Tên nhân viên
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Lấy ngày sinh của nhân viên.
     *
     * @return Ngày sinh của nhân viên
     */
    public LocalDate getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    /**
     * Đặt ngày sinh của nhân viên.
     *
     * @param employeeBirthDate Ngày sinh của nhân viên
     */
    public void setEmployeeBirthDate(LocalDate employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    /**
     * Lấy email của nhân viên.
     *
     * @return Email của nhân viên
     */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * Đặt email của nhân viên.
     *
     * @param employeeEmail Email của nhân viên
     */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    /**
     * Lấy số điện thoại của nhân viên.
     *
     * @return Số điện thoại của nhân viên
     */
    public String getEmployeeTelephone() {
        return employeeTelephone;
    }

    /**
     * Đặt số điện thoại của nhân viên.
     *
     * @param employeeTelephone Số điện thoại của nhân viên
     */
    public void setEmployeeTelephone(String employeeTelephone) {
        this.employeeTelephone = employeeTelephone;
    }
    /**
     * Lấy salt của nhân viên.
     *
     * @return salt của nhân viên
     */
    public String getSalt() {
        return salt;
    }
    /**
     * Đặt salt của nhân viên.
     *
     * @param salt salt của nhân viên
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Lấy số vai trò của nhân viên.
     *
     * @return vai trò của nhân viên
     */
    public String getRole() {
        return role;
    }

    /**
     * Đặt số vai trò của nhân viên.
     *
     * @param role vai trò của nhân viên
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Lấy phòng ban của nhân viên.
     *
     * @return Phòng ban của nhân viên
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Đặt phòng ban của nhân viên.
     *
     * @param department Phòng ban của nhân viên
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Lấy danh sách chứng chỉ của nhân viên.
     *
     * @return Danh sách chứng chỉ của nhân viên
     */
    public List<EmployeeCertification> getCertifications() {
        return certifications;
    }

    /**
     * Đặt danh sách chứng chỉ của nhân viên.
     *
     * @param certifications Danh sách chứng chỉ của nhân viên
     */
    public void setCertifications(List<EmployeeCertification> certifications) {
        this.certifications = certifications;
    }
}
