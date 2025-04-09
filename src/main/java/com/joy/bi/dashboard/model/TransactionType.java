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
@Table(name = "TransactionTypes", schema = "Application")
public class TransactionType {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[TransactionTypeID]")
    @Column(name = "TransactionTypeID", nullable = false)
    private Integer transactionTypeID;

    @Nationalized
    @Column(name = "TransactionTypeName", nullable = false, length = 50)
    private String transactionTypeName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}