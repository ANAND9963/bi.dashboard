package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.OrderCountByMonth;
import com.joy.bi.dashboard.service.PurchaseOrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping("/monthly")
    public List<OrderCountByMonth> getOrderCountsBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getOrderCountsBetween(startDate, endDate);
    }

    @GetMapping("/monthly/all")
    public List<OrderCountByMonth> getAllOrderCounts() {
        return service.getAllOrderCounts();
    }
}