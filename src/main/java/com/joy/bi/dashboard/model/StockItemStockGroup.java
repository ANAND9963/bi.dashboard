package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "StockItemStockGroups", schema = "Warehouse")
public class StockItemStockGroup {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[StockItemStockGroupID]")
    @Column(name = "StockItemStockGroupID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}