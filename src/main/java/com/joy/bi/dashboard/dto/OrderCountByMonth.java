package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCountByMonth {
    private int orderYear;
    private int orderMonth;
    private long orderCount;
}