package com.luvina.la.dto;

import lombok.Data;

/**
 * DepartmentDTO đại diện cho thông tin phòng ban.
 *
 * @author PhamToanThang
 */
@Data
public class DepartmentDTO {

    /** ID của phòng ban */
    private Long departmentId;

    /** Tên phòng ban */
    private String departmentName;

}
