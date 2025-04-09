package com.joy.bi.dashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "VehicleTemperatures", schema = "Warehouse")
public class VehicleTemperature {
    @Id
    @Column(name = "VehicleTemperatureID", nullable = false)
    private Long vehicleTemperatureID;

    @Nationalized
    @Column(name = "VehicleRegistration", nullable = false, length = 20)
    private String vehicleRegistration;

    @Column(name = "ChillerSensorNumber", nullable = false)
    private Integer chillerSensorNumber;

    @Column(name = "RecordedWhen", nullable = false)
    private Instant recordedWhen;

    @Column(name = "Temperature", nullable = false, precision = 10, scale = 2)
    private BigDecimal temperature;

    @Nationalized
    @Column(name = "FullSensorData", length = 1000)
    private String fullSensorData;

    @Column(name = "IsCompressed", nullable = false)
    private Boolean isCompressed = false;

    @Column(name = "CompressedSensorData")
    private byte[] compressedSensorData;

}