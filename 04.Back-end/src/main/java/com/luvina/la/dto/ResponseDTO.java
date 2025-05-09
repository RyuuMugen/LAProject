package com.luvina.la.dto;

import lombok.Data;
import java.util.List;

@Data
public class ResponseDTO {
    private String code;
    private List<DepartmentDTO> departments;
    private MessageDTO message;
}
