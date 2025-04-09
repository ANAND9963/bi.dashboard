package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.SupplierTransactionSummary;
import com.joy.bi.dashboard.service.SupplierTransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/supplier-transactions")// optional for frontend
public class SupplierTransactionController {

    private final SupplierTransactionService service;

    public SupplierTransactionController(SupplierTransactionService service) {
        this.service = service;
    }

    @GetMapping("/monthly")
    public List<SupplierTransactionSummary> getMonthlySummaryBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getMonthlySummaryBetween(startDate, endDate);
    }

    @GetMapping("/monthly/all")
    public List<SupplierTransactionSummary> getAllMonthlySummary() {
        return service.getAllMonthlySummary();
    }
}
