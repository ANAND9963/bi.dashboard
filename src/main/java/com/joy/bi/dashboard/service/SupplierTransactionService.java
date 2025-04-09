package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.SupplierTransactionSummary;
import com.joy.bi.dashboard.repository.SupplierTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierTransactionService {

    private final SupplierTransactionRepository repository;

    public SupplierTransactionService(SupplierTransactionRepository repository) {
        this.repository = repository;
    }

    public List<SupplierTransactionSummary> getAllMonthlySummary() {
        return mapToDto(repository.findAllMonthlySupplierTransactionSummary());
    }

    public List<SupplierTransactionSummary> getMonthlySummaryBetween(LocalDate startDate, LocalDate endDate) {
        return mapToDto(repository.findMonthlySupplierTransactionSummaryBetween(startDate, endDate));
    }

    private List<SupplierTransactionSummary> mapToDto(List<Object[]> rows) {
        return rows.stream().map(row -> new SupplierTransactionSummary(
                ((Number) row[0]).intValue(),       // Year
                ((Number) row[1]).intValue(),       // Month
                ((Number) row[2]).doubleValue(),    // TransactionAmount
                ((Number) row[3]).doubleValue(),    // AmountExcludingTax
                ((Number) row[4]).doubleValue()     // TaxAmount
        )).collect(Collectors.toList());
    }
}