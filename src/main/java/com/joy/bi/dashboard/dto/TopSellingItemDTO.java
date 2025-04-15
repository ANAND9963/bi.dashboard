package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// 1. Top Selling Items
@Data @AllArgsConstructor
public class TopSellingItemDTO {
    private Integer stockItemId;
    private String stockItemName;
    private int totalQuantitySold;
    private Double totalRevenue;
}
