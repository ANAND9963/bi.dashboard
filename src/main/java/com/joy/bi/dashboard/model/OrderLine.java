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
@Table(name = "OrderLines", schema = "Sales")
public class OrderLine {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[OrderLineID]")
    @Column(name = "OrderLineID", nullable = false)
    private Integer orderLineID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OrderID", nullable = false)
    private com.joy.bi.dashboard.model.Order orderID;

    @Nationalized
    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "TaxRate", nullable = false, precision = 18, scale = 3)
    private BigDecimal taxRate;

    @Column(name = "PickedQuantity", nullable = false)
    private Integer pickedQuantity;

    @Column(name = "PickingCompletedWhen")
    private Instant pickingCompletedWhen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}