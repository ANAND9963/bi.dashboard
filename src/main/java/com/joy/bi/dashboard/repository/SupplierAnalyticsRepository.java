package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface SupplierAnalyticsRepository extends Repository<Supplier, Long> {

    @Query(value = """
        SELECT TOP 10 
            S.SupplierName,
            COUNT(DISTINCT PO.PurchaseOrderID) AS OrderCount,
            SUM(ISNULL(ST.TransactionAmount, 0)) AS TotalTransactionAmount
        FROM Purchasing.Suppliers S
        LEFT JOIN Purchasing.PurchaseOrders PO 
            ON S.SupplierID = PO.SupplierID AND PO.OrderDate BETWEEN :startDate AND :endDate
        LEFT JOIN Purchasing.SupplierTransactions ST 
            ON PO.PurchaseOrderID = ST.PurchaseOrderID
        WHERE (:supplierId IS NULL OR S.SupplierID = :supplierId)
        GROUP BY S.SupplierName
        ORDER BY OrderCount DESC
    """, nativeQuery = true)
    List<Object[]> getTopSuppliers(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("supplierId") Integer supplierId
    );
}