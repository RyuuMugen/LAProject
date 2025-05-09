package com.luvina.la.dto;

import lombok.Data;
import java.util.List;

@Data
public class MessageDTO {
    private String code;
    private List<String> params;
}
