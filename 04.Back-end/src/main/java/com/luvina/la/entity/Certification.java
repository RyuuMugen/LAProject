package com.luvina.la.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Lớp Entity đại diện cho bảng chứng chỉ (certifications).
 * Bao gồm thông tin về mã chứng chỉ, tên chứng chỉ và cấp độ chứng chỉ.
 *
 * @author PhamToanThang
 */
@Entity
@Table(name = "certifications")
public class Certification {

    /**
     * Mã chứng chỉ (ID).
     */
    @Id
    @Column(name = "certification_id")
    private Long certificationId;

    /**
     * Tên chứng chỉ.
     */
    @Column(name = "certification_name")
    private String certificationName;

    /**
     * Cấp độ chứng chỉ.
     */
    @Column(name = "certification_level")
    private Integer certificationLevel;

    // Getter và Setter

    /**
     * Lấy mã chứng chỉ.
     *
     * @return Mã chứng chỉ
     */
    public Long getCertificationId() {
        return certificationId;
    }

    /**
     * Đặt mã chứng chỉ.
     *
     * @param certificationId Mã chứng chỉ
     */
    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    /**
     * Lấy tên chứng chỉ.
     *
     * @return Tên chứng chỉ
     */
    public String getCertificationName() {
        return certificationName;
    }

    /**
     * Đặt tên chứng chỉ.
     *
     * @param certificationName Tên chứng chỉ
     */
    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    /**
     * Lấy cấp độ chứng chỉ.
     *
     * @return Cấp độ chứng chỉ
     */
    public Integer getCertificationLevel() {
        return certificationLevel;
    }

    /**
     * Đặt cấp độ chứng chỉ.
     *
     * @param certificationLevel Cấp độ chứng chỉ
     */
    public void setCertificationLevel(Integer certificationLevel) {
        this.certificationLevel = certificationLevel;
    }
}
