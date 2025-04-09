package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "StockItemHoldings", schema = "Warehouse")
public class StockItemHolding {
    @Id
    @Column(name = "StockItemID", nullable = false)
    private Integer stockItemID;

    @Column(name = "QuantityOnHand", nullable = false)
    private Integer quantityOnHand;

    @Nationalized
    @Column(name = "BinLocation", nullable = false, length = 20)
    private String binLocation;

    @Column(name = "LastStocktakeQuantity", nullable = false)
    private Integer lastStocktakeQuantity;

    @Column(name = "LastCostPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal lastCostPrice;

    @Column(name = "ReorderLevel", nullable = false)
    private Integer reorderLevel;

    @Column(name = "TargetStockLevel", nullable = false)
    private Integer targetStockLevel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}