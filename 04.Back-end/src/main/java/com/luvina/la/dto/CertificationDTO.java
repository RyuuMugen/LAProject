package com.luvina.la.dto;

import lombok.Data;

/**
 * CertificationDTO đại diện cho thông tin chứng chỉ.
 *
 * @author PhamToanThang
 */
@Data
public class CertificationDTO {
    /** ID của phòng ban */
    private Long certificationId;

    /** Tên phòng ban */
    private String certificationName;
}
