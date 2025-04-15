package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// 6. Color Usage
@Data @AllArgsConstructor
public class ColorUsageDTO {
    private String colorName;
    private Long itemCount;
    private Double avgPrice;
}
