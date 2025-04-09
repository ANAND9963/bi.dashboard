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
@Table(name = "SupplierTransactions", schema = "Purchasing")
public class SupplierTransaction {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[TransactionID]")
    @Column(name = "SupplierTransactionID", nullable = false)
    private Integer supplierTransactionID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SupplierID", nullable = false)
    private com.joy.bi.dashboard.model.Supplier supplierID;

    @Nationalized
    @Column(name = "SupplierInvoiceNumber", length = 20)
    private String supplierInvoiceNumber;

    @Column(name = "TransactionDate", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "AmountExcludingTax", nullable = false, precision = 18, scale = 2)
    private BigDecimal amountExcludingTax;

    @Column(name = "TaxAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "TransactionAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal transactionAmount;

    @Column(name = "OutstandingBalance", nullable = false, precision = 18, scale = 2)
    private BigDecimal outstandingBalance;

    @Column(name = "FinalizationDate")
    private LocalDate finalizationDate;

    @ColumnDefault("case when [FinalizationDate] IS NULL then CONVERT([bit], 0) else CONVERT([bit], 1) end")
    @Column(name = "IsFinalized")
    private Boolean isFinalized;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}