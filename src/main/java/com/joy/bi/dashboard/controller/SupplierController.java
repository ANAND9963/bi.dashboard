package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.*;
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

    @GetMapping("/list")
    public List<SupplierOption> getAllSuppliersForDropdown() {
        return service.getAllSupplierOptions();
    }

    @GetMapping("/delivery-methods")
    public List<SupplierDeliveryMethodDTO> getDeliveryMethods() {
        return service.getDeliveryMethods();
    }

    @GetMapping("/locations")
    public List<SupplierLocationDTO> getSupplierLocations() {
        return service.getSupplierLocations();
    }

    @GetMapping("/geo")
    public List<SupplierGeoDTO> getGeoDetails() {
        return service.getSupplierGeoData();
    }

    @GetMapping("/contacts")
    public List<SupplierContactDTO> getContacts() {
        return service.getSupplierContacts();
    }
}