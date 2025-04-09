package com.joy.bi.dashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ColdRoomTemperatures", schema = "Warehouse")
public class ColdRoomTemperature {
    @Id
    @Column(name = "ColdRoomTemperatureID", nullable = false)
    private Long coldRoomTemperatureID;

    @Column(name = "ColdRoomSensorNumber", nullable = false)
    private Integer coldRoomSensorNumber;

    @Column(name = "RecordedWhen", nullable = false)
    private Instant recordedWhen;

    @Column(name = "Temperature", nullable = false, precision = 10, scale = 2)
    private BigDecimal temperature;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}