package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierGeoDTO {
    private String supplierName;
    private String continent;
    private String countryName;
    private String cityName;
}