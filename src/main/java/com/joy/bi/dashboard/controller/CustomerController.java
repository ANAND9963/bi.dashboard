package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.CustomerLocationDTO;
import com.joy.bi.dashboard.repository.CustomerRepository;
import com.joy.bi.dashboard.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/locations")
    public List<CustomerLocationDTO> getCustomerLocations() {
        return customerService.getCustomerLocations();
    }
}
