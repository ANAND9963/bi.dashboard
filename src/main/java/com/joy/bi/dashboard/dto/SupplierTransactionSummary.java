package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SupplierTransactionSummary {
    private int transactionYear;
    private int transactionMonth;
    private double totalTransactionAmount;
    private double totalAmountExcludingTax;
    private double totalTaxAmount;
}