package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

// 4. Vehicle Temp Alert
@Data @AllArgsConstructor
public class VehicleTemperatureAlertDTO {
    private String vehicleRegistration;
    private String recordedWhen;
    private Double temperature;
}
