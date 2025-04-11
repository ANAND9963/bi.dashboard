package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.CustomerLocationDTO;
import com.joy.bi.dashboard.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerLocationDTO> getCustomerLocations() {
        List<Object[]> results = customerRepository.getCustomerLocationsNative();

        return results.stream()
                .map(row -> new CustomerLocationDTO(
                        (Integer) row[0],
                        (String) row[1],
                        (String) row[2],
                        row[3] != null ? ((Number) row[3]).doubleValue() : null,
                        row[4] != null ? ((Number) row[4]).doubleValue() : null
                ))
                .collect(Collectors.toList());
    }
}