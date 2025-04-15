package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.StockGroupUsageDTO;
import com.joy.bi.dashboard.repository.StockGroupUsageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockGroupUsageService {

    private final StockGroupUsageRepository repository;

    public StockGroupUsageService(StockGroupUsageRepository repository) {
        this.repository = repository;
    }

    public List<StockGroupUsageDTO> getGroupUsageStats() {
        return repository.findStockGroupUsage()
                .stream()
                .map(row -> new StockGroupUsageDTO(
                        (String) row[0],
                        (long) ((Number) row[1]).intValue()
                ))
                .collect(Collectors.toList());
    }
}