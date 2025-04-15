package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.StockItemHolding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface StockShortageRepository extends Repository<StockItemHolding, Long> {

    @Query(value = """
        SELECT 
            SI.StockItemName,
            SH.QuantityOnHand,
            SH.ReorderLevel,
            SH.TargetStockLevel,
            (SH.TargetStockLevel - SH.QuantityOnHand) AS Shortage
        FROM Warehouse.StockItemHoldings SH
        JOIN Warehouse.StockItems SI ON SH.StockItemID = SI.StockItemID
        WHERE SH.QuantityOnHand < SH.ReorderLevel
        ORDER BY Shortage DESC
    """, nativeQuery = true)
    List<Object[]> findStockShortages();
}
