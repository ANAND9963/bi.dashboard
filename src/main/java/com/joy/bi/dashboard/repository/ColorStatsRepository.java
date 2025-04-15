package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.Color;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ColorStatsRepository extends Repository<Color, Long> {

    @Query(value = """
        SELECT 
            C.ColorName,
            COUNT(SI.StockItemID) AS ItemCount,
            AVG(SI.UnitPrice) AS AvgPrice
        FROM Warehouse.Colors C
        JOIN Warehouse.StockItems SI ON C.ColorID = SI.ColorID
        GROUP BY C.ColorName
        ORDER BY ItemCount DESC
    """, nativeQuery = true)
    List<Object[]> findColorStats();
}