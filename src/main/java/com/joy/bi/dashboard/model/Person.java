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
@Table(name = "People", schema = "Application")
public class Person {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[PersonID]")
    @Column(name = "PersonID", nullable = false)
    private Integer personID;

    @Nationalized
    @Column(name = "FullName", nullable = false, length = 50)
    private String fullName;

    @Nationalized
    @Column(name = "PreferredName", nullable = false, length = 50)
    private String preferredName;

    @Nationalized
    @ColumnDefault("concat([PreferredName], N' ', [FullName])")
    @Column(name = "SearchName", nullable = false, length = 101)
    private String searchName;

    @Column(name = "IsPermittedToLogon", nullable = false)
    private Boolean isPermittedToLogon = false;

    @Nationalized
    @Column(name = "LogonName", length = 50)
    private String logonName;

    @Column(name = "IsExternalLogonProvider", nullable = false)
    private Boolean isExternalLogonProvider = false;

    @Column(name = "HashedPassword")
    private byte[] hashedPassword;

    @Column(name = "IsSystemUser", nullable = false)
    private Boolean isSystemUser = false;

    @Column(name = "IsEmployee", nullable = false)
    private Boolean isEmployee = false;

    @Column(name = "IsSalesperson", nullable = false)
    private Boolean isSalesperson = false;

    @Nationalized
    @Lob
    @Column(name = "UserPreferences")
    private String userPreferences;

    @Nationalized
    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Nationalized
    @Column(name = "FaxNumber", length = 20)
    private String faxNumber;

    @Nationalized
    @Column(name = "EmailAddress", length = 256)
    private String emailAddress;

    @Column(name = "Photo")
    private byte[] photo;

    @Nationalized
    @Lob
    @Column(name = "CustomFields")
    private String customFields;

    @Nationalized
    @ColumnDefault("json_query([CustomFields], N'$.OtherLanguages')")
    @Lob
    @Column(name = "OtherLanguages")
    private String otherLanguages;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

}