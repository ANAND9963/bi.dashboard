package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerLocationDTO {
    private Integer customerId;
    private String customerName;
    private String cityName;
    private Double latitude;
    private Double longitude;
}