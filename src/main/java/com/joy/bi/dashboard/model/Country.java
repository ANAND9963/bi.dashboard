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
@Table(name = "Countries", schema = "Application")
public class Country {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[CountryID]")
    @Column(name = "CountryID", nullable = false)
    private Integer countryID;

    @Nationalized
    @Column(name = "CountryName", nullable = false, length = 60)
    private String countryName;

    @Nationalized
    @Column(name = "FormalName", nullable = false, length = 60)
    private String formalName;

    @Nationalized
    @Column(name = "IsoAlpha3Code", length = 3)
    private String isoAlpha3Code;

    @Column(name = "IsoNumericCode")
    private Integer isoNumericCode;

    @Nationalized
    @Column(name = "CountryType", length = 20)
    private String countryType;

    @Column(name = "LatestRecordedPopulation")
    private Long latestRecordedPopulation;

    @Nationalized
    @Column(name = "Continent", nullable = false, length = 30)
    private String continent;

    @Nationalized
    @Column(name = "Region", nullable = false, length = 30)
    private String region;

    @Nationalized
    @Column(name = "Subregion", nullable = false, length = 30)
    private String subregion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

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