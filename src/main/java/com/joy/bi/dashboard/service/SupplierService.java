package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.SupplierCountByCategory;
import com.joy.bi.dashboard.dto.SupplierOption;
import com.joy.bi.dashboard.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<SupplierCountByCategory> getSupplierCounts(Integer categoryId) {
        return repository.countSuppliersByCategory(categoryId)
                .stream()
                .map(row -> new SupplierCountByCategory(
                        (String) row[0],
                        ((Number) row[1]).longValue()
                ))
                .collect(Collectors.toList());
    }

    public List<SupplierOption> getAllSupplierOptions() {
        return repository.findAllSupplierOptionsNative().stream()
                .map(row -> new SupplierOption(
                        ((Number) row[0]).intValue(),
                        (String) row[1]
                ))
                .collect(Collectors.toList());
    }

}