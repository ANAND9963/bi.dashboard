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
@Table(name = "StockGroups", schema = "Warehouse")
public class StockGroup {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[StockGroupID]")
    @Column(name = "StockGroupID", nullable = false)
    private Integer stockGroupID;

    @Nationalized
    @Column(name = "StockGroupName", nullable = false, length = 50)
    private String stockGroupName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}