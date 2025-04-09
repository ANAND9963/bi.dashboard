package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SupplierCountByCategory {
    private String supplierCategoryName;
    private long supplierCount;
}