package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.ColdRoomTemperature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ColdRoomTemperatureRepository extends Repository<ColdRoomTemperature, Long> {

    @Query(value = """
        SELECT 
            ColdRoomSensorNumber,
            CAST(RecordedWhen AS DATE) AS RecordedDate,
            AVG(Temperature) AS AvgTemperature,
            MIN(Temperature) AS MinTemp,
            MAX(Temperature) AS MaxTemp
        FROM Warehouse.ColdRoomTemperatures
        GROUP BY ColdRoomSensorNumber, CAST(RecordedWhen AS DATE)
        ORDER BY ColdRoomSensorNumber, RecordedDate
    """, nativeQuery = true)
    List<Object[]> getColdRoomTemperatureStats();
}