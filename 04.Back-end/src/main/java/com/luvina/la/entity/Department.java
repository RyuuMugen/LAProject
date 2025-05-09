package com.luvina.la.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Lớp Entity đại diện cho bảng phòng ban (departments).
 * Bao gồm thông tin về mã phòng ban và tên phòng ban.
 *
 * @author PhamToanThang
 */
@Entity
@Table(name = "departments")
public class Department {

    /**
     * Mã phòng ban (ID).
     */
    @Id
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * Tên phòng ban.
     */
    @Column(name = "department_name")
    private String departmentName;

    // Getter và Setter

    /**
     * Lấy mã phòng ban.
     *
     * @return Mã phòng ban
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * Đặt mã phòng ban.
     *
     * @param departmentId Mã phòng ban
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Lấy tên phòng ban.
     *
     * @return Tên phòng ban
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Đặt tên phòng ban.
     *
     * @param departmentName Tên phòng ban
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
