package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.StockItemTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TopSellingItemsRepository extends Repository<StockItemTransaction, Long> {

    @Query(value = """
        SELECT TOP 10 
            SI.StockItemID AS stockItemId,
            SI.StockItemName AS stockItemName,
            SUM(SIT.Quantity) AS totalQuantitySold,
            SUM(SIT.Quantity * SI.UnitPrice) AS totalRevenue
        FROM Warehouse.StockItemTransactions SIT
        JOIN Warehouse.StockItems SI ON SIT.StockItemID = SI.StockItemID
        GROUP BY SI.StockItemID, SI.StockItemName, SI.UnitPrice
        ORDER BY totalRevenue DESC
    """, nativeQuery = true)
    List<Object[]> findTopStockItemsByRevenue();
}
