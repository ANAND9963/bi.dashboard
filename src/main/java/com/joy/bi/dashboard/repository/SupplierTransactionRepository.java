package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.SupplierTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface SupplierTransactionRepository extends Repository<SupplierTransaction, Long> {

    @Query(value = """
        SELECT 
            YEAR(TransactionDate),
            MONTH(TransactionDate),
            SUM(TransactionAmount),
            SUM(AmountExcludingTax),
            SUM(TaxAmount)
        FROM Purchasing.SupplierTransactions
        GROUP BY YEAR(TransactionDate), MONTH(TransactionDate)
        ORDER BY YEAR(TransactionDate), MONTH(TransactionDate)
    """, nativeQuery = true)
    List<Object[]> findAllMonthlySupplierTransactionSummary();

    @Query(value = """
        SELECT 
            YEAR(TransactionDate),
            MONTH(TransactionDate),
            SUM(TransactionAmount),
            SUM(AmountExcludingTax),
            SUM(TaxAmount)
        FROM Purchasing.SupplierTransactions
        WHERE TransactionDate BETWEEN :startDate AND :endDate
        GROUP BY YEAR(TransactionDate), MONTH(TransactionDate)
        ORDER BY YEAR(TransactionDate), MONTH(TransactionDate)
    """, nativeQuery = true)
    List<Object[]> findMonthlySupplierTransactionSummaryBetween(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
