package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

// 2. Cold Room Temperatures
@Data @AllArgsConstructor
public class ColdRoomTemperatureDTO {
    private int sensorNumber;
    private String recordedDate;
    private Double avgTemp;
    private Double minTemp;
    private Double maxTemp;
}
