package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.StockGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface StockGroupUsageRepository extends Repository<StockGroup, Long> {

    @Query(value = """
        SELECT 
            SG.StockGroupName,
            COUNT(SISG.StockItemID) AS ItemUsageCount
        FROM Warehouse.StockGroups SG
        JOIN Warehouse.StockItemStockGroups SISG ON SG.StockGroupID = SISG.StockGroupID
        GROUP BY SG.StockGroupName
        ORDER BY ItemUsageCount DESC
    """, nativeQuery = true)
    List<Object[]> findStockGroupUsage();
}
