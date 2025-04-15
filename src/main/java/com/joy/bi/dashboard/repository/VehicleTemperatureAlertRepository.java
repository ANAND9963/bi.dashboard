package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.VehicleTemperature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface VehicleTemperatureAlertRepository extends Repository<VehicleTemperature, Long> {

    @Query(value = """
        SELECT 
            VehicleRegistration,
            RecordedWhen,
            Temperature
        FROM Warehouse.VehicleTemperatures
        WHERE Temperature > 4.2 OR Temperature < 0
        ORDER BY RecordedWhen DESC
    """, nativeQuery = true)
    List<Object[]> findVehicleTemperatureAlerts();
}