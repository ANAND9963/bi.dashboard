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
@Table(name = "Invoices", schema = "Sales")
public class Invoice {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[InvoiceID]")
    @Column(name = "InvoiceID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customerID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BillToCustomerID", nullable = false)
    private Customer billToCustomerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private com.joy.bi.dashboard.model.Order orderID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ContactPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person contactPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AccountsPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person accountsPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SalespersonPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person salespersonPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PackedByPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person packedByPersonID;

    @Column(name = "InvoiceDate", nullable = false)
    private LocalDate invoiceDate;

    @Nationalized
    @Column(name = "CustomerPurchaseOrderNumber", length = 20)
    private String customerPurchaseOrderNumber;

    @Column(name = "IsCreditNote", nullable = false)
    private Boolean isCreditNote = false;

    @Nationalized
    @Lob
    @Column(name = "CreditNoteReason")
    private String creditNoteReason;

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

    @Column(name = "TotalDryItems", nullable = false)
    private Integer totalDryItems;

    @Column(name = "TotalChillerItems", nullable = false)
    private Integer totalChillerItems;

    @Nationalized
    @Column(name = "DeliveryRun", length = 5)
    private String deliveryRun;

    @Nationalized
    @Column(name = "RunPosition", length = 5)
    private String runPosition;

    @Nationalized
    @Lob
    @Column(name = "ReturnedDeliveryData")
    private String returnedDeliveryData;

    @ColumnDefault("TRY_CONVERT([datetime2](7), json_value([ReturnedDeliveryData], N'$.DeliveredWhen'), 126)")
    @Column(name = "ConfirmedDeliveryTime")
    private Instant confirmedDeliveryTime;

    @Nationalized
    @ColumnDefault("json_value([ReturnedDeliveryData], N'$.ReceivedBy')")
    @Column(name = "ConfirmedReceivedBy", length = 4000)
    private String confirmedReceivedBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}