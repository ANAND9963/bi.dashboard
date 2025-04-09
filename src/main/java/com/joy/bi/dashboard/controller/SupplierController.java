package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.SupplierCountByCategory;
import com.joy.bi.dashboard.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping("/count-by-category")
    public List<SupplierCountByCategory> getSupplierCountsByCategory(
            @RequestParam(required = false) Integer supplierCategoryId
    ) {
        return service.getSupplierCounts(supplierCategoryId);
    }
}