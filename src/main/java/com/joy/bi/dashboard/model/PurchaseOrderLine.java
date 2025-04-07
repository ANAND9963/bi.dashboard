package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PurchaseOrderLines", schema = "Purchasing")
public class PurchaseOrderLine {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[PurchaseOrderLineID]")
    @Column(name = "PurchaseOrderLineID", nullable = false)
    private Integer id;

    @Column(name = "OrderedOuters", nullable = false)
    private Integer orderedOuters;

    @Nationalized
    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    @Column(name = "ReceivedOuters", nullable = false)
    private Integer receivedOuters;

    @Column(name = "ExpectedUnitPricePerOuter", precision = 18, scale = 2)
    private BigDecimal expectedUnitPricePerOuter;

    @Column(name = "LastReceiptDate")
    private LocalDate lastReceiptDate;

    @Column(name = "IsOrderLineFinalized", nullable = false)
    private Boolean isOrderLineFinalized = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}