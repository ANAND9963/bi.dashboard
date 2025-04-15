package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.StockShortageDTO;
import com.joy.bi.dashboard.repository.StockShortageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockShortageService {

    private final StockShortageRepository repository;

    public StockShortageService(StockShortageRepository repository) {
        this.repository = repository;
    }

    public List<StockShortageDTO> getShortages() {
        return repository.findStockShortages()
                .stream()
                .map(row -> new StockShortageDTO(
                        (String) row[0],
                        ((Number) row[1]).intValue(),
                        ((Number) row[2]).intValue(),
                        ((Number) row[3]).intValue(),
                        ((Number) row[4]).intValue()
                ))
                .collect(Collectors.toList());
    }
}