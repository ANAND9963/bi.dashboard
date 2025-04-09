package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.dto.SupplierOption;
import com.joy.bi.dashboard.model.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface SupplierRepository extends Repository<Supplier, Long> {

    @Query(value = """
        SELECT 
            SC.SupplierCategoryName,
            COUNT(*) AS SupplierCount
        FROM Purchasing.Suppliers S
        JOIN Purchasing.SupplierCategories SC
            ON S.SupplierCategoryID = SC.SupplierCategoryID
        WHERE (:categoryId IS NULL OR S.SupplierCategoryID = :categoryId)
        GROUP BY SC.SupplierCategoryName
        ORDER BY SupplierCount DESC
    """, nativeQuery = true)
    List<Object[]> countSuppliersByCategory(@Param("categoryId") Integer categoryId);

    @Query(value = "SELECT s.SupplierID, s.SupplierName FROM Purchasing.Suppliers s", nativeQuery = true)
    List<Object[]> findAllSupplierOptionsNative();


}