package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.dto.CustomerLocationDTO;
import com.joy.bi.dashboard.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends Repository<com.joy.bi.dashboard.model.Customer, Integer> {

    @Query(value = """
        SELECT 
            CU.CustomerID,
            CU.CustomerName,
            C.CityName,
            C.Location.Lat AS Latitude,
            C.Location.Long AS Longitude
        FROM Sales.Customers CU
        JOIN Application.Cities C ON CU.DeliveryCityID = C.CityID
        WHERE C.Location IS NOT NULL
    """, nativeQuery = true)
    List<Object[]> getCustomerLocationsNative();
}