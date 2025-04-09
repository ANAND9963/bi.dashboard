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
@Table(name = "Orders", schema = "Sales")
public class Order {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[OrderID]")
    @Column(name = "OrderID", nullable = false)
    private Integer orderID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customerID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SalespersonPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person salespersonPersonID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PickedByPersonID")
    private com.joy.bi.dashboard.model.Person pickedByPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ContactPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person contactPersonID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BackorderOrderID")
    private Order backorderOrderID;

    @Column(name = "OrderDate", nullable = false)
    private LocalDate orderDate;

    @Column(name = "ExpectedDeliveryDate", nullable = false)
    private LocalDate expectedDeliveryDate;

    @Nationalized
    @Column(name = "CustomerPurchaseOrderNumber", length = 20)
    private String customerPurchaseOrderNumber;

    @Column(name = "IsUndersupplyBackordered", nullable = false)
    private Boolean isUndersupplyBackordered = false;

    @Nationalized
    @Lob
    @Column(name = "Comments")
    private String comments;

    @Nationalized
    @Lob
    @Column(name = "DeliveryInstructions")
    private String deliveryInstructions;

    @Nationalized
    @Lob
    @Column(name = "InternalComments")
    private String internalComments;

    @Column(name = "PickingCompletedWhen")
    private Instant pickingCompletedWhen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}