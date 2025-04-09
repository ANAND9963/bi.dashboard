package com.joy.bi.dashboard.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopSupplierReport {
    private String supplierName;
    private long orderCount;
    private double totalTransactionAmount;
}