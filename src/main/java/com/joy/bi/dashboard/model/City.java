package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Cities", schema = "Application")
public class City {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[CityID]")
    @Column(name = "CityID", nullable = false)
    private Integer cityID;

    @Nationalized
    @Column(name = "CityName", nullable = false, length = 50)
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "StateProvinceID", nullable = false)
    private com.joy.bi.dashboard.model.StateProvince stateProvinceID;

    @Column(name = "LatestRecordedPopulation")
    private Long latestRecordedPopulation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;
    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

/*
 TODO [Reverse Engineering] create field to map the 'Location' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "Location", columnDefinition = "geography")
    private Object location;
*/
}