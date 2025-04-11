package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierLocationDTO {
    private String supplierName;
    private String cityName;
    private Double latitude;
    private Double longitude;
}