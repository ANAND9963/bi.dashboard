package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.TopSupplierReport;
import com.joy.bi.dashboard.service.SupplierAnalyticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/supplier-analytics")
public class SupplierAnalyticsController {

    private final SupplierAnalyticsService service;

    public SupplierAnalyticsController(SupplierAnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/top-suppliers")
    public List<TopSupplierReport> getTopSuppliers(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) Integer supplierId
    ) {
        return service.getTopSuppliers(startDate, endDate, supplierId);
    }
}