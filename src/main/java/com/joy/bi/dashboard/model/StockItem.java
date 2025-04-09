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
@Table(name = "StockItems", schema = "Warehouse")
public class StockItem {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[StockItemID]")
    @Column(name = "StockItemID", nullable = false)
    private Integer stockItemID;

    @Nationalized
    @Column(name = "StockItemName", nullable = false, length = 100)
    private String stockItemName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SupplierID", nullable = false)
    private com.joy.bi.dashboard.model.Supplier supplierID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ColorID")
    private Color colorID;

    @Nationalized
    @Column(name = "Brand", length = 50)
    private String brand;

    @Nationalized
    @Column(name = "\"Size\"", length = 20)
    private String size;

    @Column(name = "LeadTimeDays", nullable = false)
    private Integer leadTimeDays;

    @Column(name = "QuantityPerOuter", nullable = false)
    private Integer quantityPerOuter;

    @Column(name = "IsChillerStock", nullable = false)
    private Boolean isChillerStock = false;

    @Nationalized
    @Column(name = "Barcode", length = 50)
    private String barcode;

    @Column(name = "TaxRate", nullable = false, precision = 18, scale = 3)
    private BigDecimal taxRate;

    @Column(name = "UnitPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "RecommendedRetailPrice", precision = 18, scale = 2)
    private BigDecimal recommendedRetailPrice;

    @Column(name = "TypicalWeightPerUnit", nullable = false, precision = 18, scale = 3)
    private BigDecimal typicalWeightPerUnit;

    @Nationalized
    @Lob
    @Column(name = "MarketingComments")
    private String marketingComments;

    @Nationalized
    @Lob
    @Column(name = "InternalComments")
    private String internalComments;

    @Column(name = "Photo")
    private byte[] photo;

    @Nationalized
    @Lob
    @Column(name = "CustomFields")
    private String customFields;

    @Nationalized
    @ColumnDefault("json_query([CustomFields], N'$.Tags')")
    @Lob
    @Column(name = "Tags")
    private String tags;

    @Nationalized
    @ColumnDefault("concat([StockItemName], N' ', [MarketingComments])")
    @Lob
    @Column(name = "SearchDetails", nullable = false)
    private String searchDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}