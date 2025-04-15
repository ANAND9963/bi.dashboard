package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.PackageType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface PackageTypeStatsRepository extends Repository<PackageType, Long> {

    @Query(value = """
        SELECT 
            PT.PackageTypeName,
            COUNT(SI.StockItemID) AS StockItemCount
        FROM Warehouse.PackageTypes PT
        JOIN Warehouse.StockItems SI ON SI.UnitPackageID = PT.PackageTypeID
        GROUP BY PT.PackageTypeName
        ORDER BY StockItemCount DESC
    """, nativeQuery = true)
    List<Object[]> findPackageTypeStats();
}