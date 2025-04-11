package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.dto.*;
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

    @Query(value = """
        SELECT 
            s.SupplierName,
            dm.DeliveryMethodName
        FROM Purchasing.Suppliers s
        JOIN Application.DeliveryMethods dm ON s.DeliveryMethodID = dm.DeliveryMethodID
        ORDER BY s.SupplierName
    """, nativeQuery = true)
    List<Object[]> getSupplierDeliveryMethodsNative();

    @Query(value = """
        SELECT 
            s.SupplierName,
            c.CityName,
            c.Location.Lat AS Latitude,
            c.Location.Long AS Longitude
        FROM Purchasing.Suppliers s
        JOIN Application.Cities c ON s.DeliveryCityID = c.CityID
        WHERE c.Location IS NOT NULL
    """, nativeQuery = true)
    List<Object[]> getSupplierLocationsNative();

    @Query(value = """
        SELECT 
            s.SupplierName,
            co.Continent,
            co.CountryName,
            c.CityName
        FROM Purchasing.Suppliers s
        JOIN Application.Cities c ON s.DeliveryCityID = c.CityID
        JOIN Application.StateProvinces sp ON c.StateProvinceID = sp.StateProvinceID
        JOIN Application.Countries co ON sp.CountryID = co.CountryID
        ORDER BY co.Continent, s.SupplierName
    """, nativeQuery = true)
    List<Object[]> getSupplierGeoDetailsNative();

    @Query(value = """
        SELECT 
            s.SupplierName,
            p.FullName,
            p.EmailAddress,
            p.PhoneNumber
        FROM Purchasing.Suppliers s
        JOIN Application.People p ON s.PrimaryContactPersonID = p.PersonID
    """, nativeQuery = true)
    List<Object[]> getSupplierContactsNative();
}
