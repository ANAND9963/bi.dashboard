package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.TopSellingItemDTO;
import com.joy.bi.dashboard.repository.TopSellingItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopSellingItemsService {

    private final TopSellingItemsRepository repository;

    public TopSellingItemsService(TopSellingItemsRepository repository) {
        this.repository = repository;
    }

    public List<TopSellingItemDTO> getTopSellingItems() {
        return repository.findTopStockItemsByRevenue()
                .stream()
                .map(row -> new TopSellingItemDTO(
                        ((Number) row[0]).intValue(),          // StockItemID
                        (String) row[1],                       // StockItemName
                        ((Number) row[2]).intValue(),          // TotalQuantitySold
                        ((Number) row[3]).doubleValue()        // TotalRevenue
                ))
                .collect(Collectors.toList());
    }
}