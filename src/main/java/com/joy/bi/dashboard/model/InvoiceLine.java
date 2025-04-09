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
@Table(name = "InvoiceLines", schema = "Sales")
public class InvoiceLine {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[InvoiceLineID]")
    @Column(name = "InvoiceLineID", nullable = false)
    private Integer InvoiceLineID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "InvoiceID", nullable = false)
    private com.joy.bi.dashboard.model.Invoice invoiceID;

    @Nationalized
    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "TaxRate", nullable = false, precision = 18, scale = 3)
    private BigDecimal taxRate;

    @Column(name = "TaxAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "LineProfit", nullable = false, precision = 18, scale = 2)
    private BigDecimal lineProfit;

    @Column(name = "ExtendedPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal extendedPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @ColumnDefault("sysdatetime()")
    @Column(name = "LastEditedWhen", nullable = false)
    private Instant lastEditedWhen;

}