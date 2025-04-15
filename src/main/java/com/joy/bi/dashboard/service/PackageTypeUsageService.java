package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.PackageTypeUsageDTO;
import com.joy.bi.dashboard.repository.PackageTypeStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageTypeUsageService {

    private final PackageTypeStatsRepository repository;

    public PackageTypeUsageService(PackageTypeStatsRepository repository) {
        this.repository = repository;
    }

    public List<PackageTypeUsageDTO> getUsageData() {
        return repository.findPackageTypeStats()
                .stream()
                .map(row -> new PackageTypeUsageDTO(
                        (String) row[0],
                        (long) ((Number) row[1]).intValue()
                ))
                .collect(Collectors.toList());
    }
}
