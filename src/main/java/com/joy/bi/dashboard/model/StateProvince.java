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
@Table(name = "StateProvinces", schema = "Application")
public class StateProvince {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[StateProvinceID]")
    @Column(name = "StateProvinceID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "StateProvinceCode", nullable = false, length = 5)
    private String stateProvinceCode;

    @Nationalized
    @Column(name = "StateProvinceName", nullable = false, length = 50)
    private String stateProvinceName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CountryID", nullable = false)
    private Country countryID;

    @Nationalized
    @Column(name = "SalesTerritory", nullable = false, length = 50)
    private String salesTerritory;

    @Column(name = "LatestRecordedPopulation")
    private Long latestRecordedPopulation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;
    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

/*
 TODO [Reverse Engineering] create field to map the 'Border' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "Border", columnDefinition = "geography")
    private Object border;
*/
}