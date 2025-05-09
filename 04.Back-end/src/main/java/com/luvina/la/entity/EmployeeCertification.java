package com.luvina.la.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Lớp Entity đại diện cho bảng chứng chỉ của nhân viên (employee_certifications).
 * Bao gồm thông tin về nhân viên, chứng chỉ và các chi tiết liên quan.
 *
 * @author PhamToanThang
 */
@Entity
@Table(name = "employee_certifications")
public class EmployeeCertification {

    /**
     * Mã chứng chỉ nhân viên (ID).
     */
    @Id
    @Column(name = "employee_certification_id")
    private Long employeeCertificationId;

    /**
     * Nhân viên sở hữu chứng chỉ này.
     */
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    /**
     * Chứng chỉ liên quan đến nhân viên này.
     */
    @ManyToOne
    @JoinColumn(name = "certification_id", referencedColumnName = "certification_id")
    private Certification certification;

    /**
     * Ngày bắt đầu chứng chỉ.
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * Ngày kết thúc chứng chỉ.
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * Điểm số đạt được từ chứng chỉ.
     */
    @Column(name = "score")
    private Double score;

    // Getter và Setter

    /**
     * Lấy mã chứng chỉ nhân viên.
     *
     * @return Mã chứng chỉ nhân viên
     */
    public Long getEmployeeCertificationId() {
        return employeeCertificationId;
    }

    /**
     * Đặt mã chứng chỉ nhân viên.
     *
     * @param employeeCertificationId Mã chứng chỉ nhân viên
     */
    public void setEmployeeCertificationId(Long employeeCertificationId) {
        this.employeeCertificationId = employeeCertificationId;
    }

    /**
     * Lấy nhân viên sở hữu chứng chỉ này.
     *
     * @return Nhân viên sở hữu chứng chỉ
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Đặt nhân viên sở hữu chứng chỉ này.
     *
     * @param employee Nhân viên sở hữu chứng chỉ
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Lấy chứng chỉ của nhân viên này.
     *
     * @return Chứng chỉ của nhân viên
     */
    public Certification getCertification() {
        return certification;
    }

    /**
     * Đặt chứng chỉ của nhân viên này.
     *
     * @param certification Chứng chỉ của nhân viên
     */
    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    /**
     * Lấy ngày bắt đầu chứng chỉ.
     *
     * @return Ngày bắt đầu chứng chỉ
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Đặt ngày bắt đầu chứng chỉ.
     *
     * @param startDate Ngày bắt đầu chứng chỉ
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Lấy ngày kết thúc chứng chỉ.
     *
     * @return Ngày kết thúc chứng chỉ
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Đặt ngày kết thúc chứng chỉ.
     *
     * @param endDate Ngày kết thúc chứng chỉ
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Lấy điểm số từ chứng chỉ.
     *
     * @return Điểm số chứng chỉ
     */
    public Double getScore() {
        return score;
    }

    /**
     * Đặt điểm số từ chứng chỉ.
     *
     * @param score Điểm số chứng chỉ
     */
    public void setScore(Double score) {
        this.score = score;
    }
}
