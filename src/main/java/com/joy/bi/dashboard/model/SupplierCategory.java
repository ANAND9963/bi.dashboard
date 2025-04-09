package com.joy.bi.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "SupplierCategories", schema = "Purchasing")
public class SupplierCategory {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[SupplierCategoryID]")
    @Column(name = "SupplierCategoryID", nullable = false)
    private Integer supplierCategoryID;

    @Nationalized
    @Column(name = "SupplierCategoryName", nullable = false, length = 50)
    private String supplierCategoryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}