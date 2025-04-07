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
@Table(name = "CustomerCategories", schema = "Sales")
public class CustomerCategory {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[CustomerCategoryID]")
    @Column(name = "CustomerCategoryID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "CustomerCategoryName", nullable = false, length = 50)
    private String customerCategoryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}