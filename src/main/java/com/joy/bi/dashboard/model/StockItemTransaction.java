package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "StockItemTransactions", schema = "Warehouse")
public class StockItemTransaction {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[TransactionID]")
    @Column(name = "StockItemTransactionID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    private Customer customerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceID")
    private Invoice invoiceID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupplierID")
    private com.joy.bi.dashboard.model.Supplier supplierID;

    @Column(name = "TransactionOccurredWhen", nullable = false)
    private Instant transactionOccurredWhen;

    @Column(name = "Quantity", nullable = false, precision = 18, scale = 3)
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}