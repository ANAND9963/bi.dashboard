package com.joy.bi.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenueStatsDto {
    private int year;
    private int quarter;
    private double revenue;
    private int orders;
    private double avgOrderValue;
}
