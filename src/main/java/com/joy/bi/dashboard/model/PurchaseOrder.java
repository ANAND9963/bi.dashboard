package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PurchaseOrders", schema = "Purchasing")
public class PurchaseOrder {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[PurchaseOrderID]")
    @Column(name = "PurchaseOrderID", nullable = false)
    private Integer purchaseOrderID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SupplierID", nullable = false)
    private com.joy.bi.dashboard.model.Supplier supplierID;

    @Column(name = "OrderDate", nullable = false)
    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ContactPersonID", nullable = false)
    private Person contactPersonID;

    @Column(name = "ExpectedDeliveryDate")
    private LocalDate expectedDeliveryDate;

    @Nationalized
    @Column(name = "SupplierReference", length = 20)
    private String supplierReference;

    @Column(name = "IsOrderFinalized", nullable = false)
    private Boolean isOrderFinalized = false;

    @Nationalized
    @Lob
    @Column(name = "Comments")
    private String comments;

    @Nationalized
    @Lob
    @Column(name = "InternalComments")
    private String internalComments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}