package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.OrderCountByMonth;
import com.joy.bi.dashboard.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderCountByMonth> getOrderCountsBetween(LocalDate startDate, LocalDate endDate) {
        List<Object[]> rows = repository.findOrderCountByMonthBetweenNative(startDate, endDate);
        return mapToDto(rows);
    }

    public List<OrderCountByMonth> getAllOrderCounts() {
        List<Object[]> rows = repository.findAllOrderCountsByMonthNative();
        return mapToDto(rows);
    }

    private List<OrderCountByMonth> mapToDto(List<Object[]> rows) {
        return rows.stream()
                .map(row -> new OrderCountByMonth(
                        ((Number) row[0]).intValue(), // OrderYear
                        ((Number) row[1]).intValue(), // OrderMonth
                        ((Number) row[2]).longValue() // OrderCount
                ))
                .collect(Collectors.toList());
    }
}