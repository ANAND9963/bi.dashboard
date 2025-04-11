package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.*;
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

    public List<SupplierDeliveryMethodDTO> getDeliveryMethods() {
        return repository.getSupplierDeliveryMethodsNative().stream()
                .map(row -> new SupplierDeliveryMethodDTO(
                        (String) row[0],
                        (String) row[1]
                ))
                .collect(Collectors.toList());
    }

    public List<SupplierLocationDTO> getSupplierLocations() {
        return repository.getSupplierLocationsNative().stream()
                .map(row -> new SupplierLocationDTO(
                        (String) row[0],
                        (String) row[1],
                        row[2] != null ? ((Number) row[2]).doubleValue() : null,
                        row[3] != null ? ((Number) row[3]).doubleValue() : null
                ))
                .collect(Collectors.toList());
    }

    public List<SupplierGeoDTO> getSupplierGeoData() {
        return repository.getSupplierGeoDetailsNative().stream()
                .map(row -> new SupplierGeoDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }

    public List<SupplierContactDTO> getSupplierContacts() {
        return repository.getSupplierContactsNative().stream()
                .map(row -> new SupplierContactDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }
}
