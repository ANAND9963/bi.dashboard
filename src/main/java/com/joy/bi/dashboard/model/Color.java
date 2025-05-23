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
@Table(name = "Colors", schema = "Warehouse")
public class Color {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[ColorID]")
    @Column(name = "ColorID", nullable = false)
    private Integer colorID;

    @Nationalized
    @Column(name = "ColorName", nullable = false, length = 20)
    private String colorName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private com.joy.bi.dashboard.model.Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}