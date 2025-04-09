package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.dto.OrderCountByMonth;
import com.joy.bi.dashboard.model.PurchaseOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface PurchaseOrderRepository extends Repository<PurchaseOrder, Long> {

    @Query(value = """
        SELECT 
            DATEPART(YEAR, OrderDate) AS OrderYear,
            DATEPART(MONTH, OrderDate) AS OrderMonth,
            COUNT(*) AS OrderCount
        FROM Purchasing.PurchaseOrders
        WHERE OrderDate BETWEEN :startDate AND :endDate
        GROUP BY DATEPART(YEAR, OrderDate), DATEPART(MONTH, OrderDate)
        ORDER BY OrderYear, OrderMonth
    """, nativeQuery = true)
    List<Object[]> findOrderCountByMonthBetweenNative(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query(value = """
        SELECT 
            DATEPART(YEAR, OrderDate) AS OrderYear,
            DATEPART(MONTH, OrderDate) AS OrderMonth,
            COUNT(*) AS OrderCount
        FROM Purchasing.PurchaseOrders
        GROUP BY DATEPART(YEAR, OrderDate), DATEPART(MONTH, OrderDate)
        ORDER BY OrderYear, OrderMonth
    """, nativeQuery = true)
    List<Object[]> findAllOrderCountsByMonthNative();
}