package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.TopSupplierReport;
import com.joy.bi.dashboard.repository.SupplierAnalyticsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierAnalyticsService {

    private final SupplierAnalyticsRepository repository;

    public SupplierAnalyticsService(SupplierAnalyticsRepository repository) {
        this.repository = repository;
    }

    public List<TopSupplierReport> getTopSuppliers(LocalDate startDate, LocalDate endDate, Integer supplierId) {
        return repository.getTopSuppliers(startDate, endDate, supplierId).stream()
                .map(row -> new TopSupplierReport(
                        (String) row[0],
                        ((Number) row[1]).longValue(),
                        ((Number) row[2]).doubleValue()
                ))
                .collect(Collectors.toList());
    }
}