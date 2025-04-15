package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.Instant;

// 7. Stock Group Usage
@Data @AllArgsConstructor
public class StockGroupUsageDTO {
    private String groupName;
    private Long itemUsageCount;
}
