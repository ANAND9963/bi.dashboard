package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CustomerTransactions", schema = "Sales")
public class CustomerTransaction {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[TransactionID]")
    @Column(name = "CustomerTransactionID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private com.joy.bi.dashboard.model.Customer customerID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TransactionTypeID", nullable = false)
    private com.joy.bi.dashboard.model.TransactionType transactionTypeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceID")
    private com.joy.bi.dashboard.model.Invoice invoiceID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PaymentMethodID")
    private com.joy.bi.dashboard.model.PaymentMethod paymentMethodID;

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
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}