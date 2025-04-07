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
@Table(name = "Suppliers", schema = "Purchasing")
public class Supplier {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[SupplierID]")
    @Column(name = "SupplierID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "SupplierName", nullable = false, length = 100)
    private String supplierName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PrimaryContactPersonID", nullable = false)
    private Person primaryContactPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AlternateContactPersonID", nullable = false)
    private Person alternateContactPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DeliveryCityID", nullable = false)
    private City deliveryCityID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PostalCityID", nullable = false)
    private City postalCityID;

    @Nationalized
    @Column(name = "SupplierReference", length = 20)
    private String supplierReference;

    @Nationalized
    @Column(name = "BankAccountName", length = 50)
    private String bankAccountName;

    @Nationalized
    @Column(name = "BankAccountBranch", length = 50)
    private String bankAccountBranch;

    @Nationalized
    @Column(name = "BankAccountCode", length = 20)
    private String bankAccountCode;

    @Nationalized
    @Column(name = "BankAccountNumber", length = 20)
    private String bankAccountNumber;

    @Nationalized
    @Column(name = "BankInternationalCode", length = 20)
    private String bankInternationalCode;

    @Column(name = "PaymentDays", nullable = false)
    private Integer paymentDays;

    @Nationalized
    @Lob
    @Column(name = "InternalComments")
    private String internalComments;

    @Nationalized
    @Column(name = "PhoneNumber", nullable = false, length = 20)
    private String phoneNumber;

    @Nationalized
    @Column(name = "FaxNumber", nullable = false, length = 20)
    private String faxNumber;

    @Nationalized
    @Column(name = "WebsiteURL", nullable = false, length = 256)
    private String websiteURL;

    @Nationalized
    @Column(name = "DeliveryAddressLine1", nullable = false, length = 60)
    private String deliveryAddressLine1;

    @Nationalized
    @Column(name = "DeliveryAddressLine2", length = 60)
    private String deliveryAddressLine2;

    @Nationalized
    @Column(name = "DeliveryPostalCode", nullable = false, length = 10)
    private String deliveryPostalCode;

    @Nationalized
    @Column(name = "PostalAddressLine1", nullable = false, length = 60)
    private String postalAddressLine1;

    @Nationalized
    @Column(name = "PostalAddressLine2", length = 60)
    private String postalAddressLine2;

    @Nationalized
    @Column(name = "PostalPostalCode", nullable = false, length = 10)
    private String postalPostalCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LastEditedBy", nullable = false)
    private Person lastEditedBy;

    @Column(name = "ValidFrom", nullable = false)
    private Instant validFrom;
    @Column(name = "ValidTo", nullable = false)
    private Instant validTo;

/*
 TODO [Reverse Engineering] create field to map the 'DeliveryLocation' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "DeliveryLocation", columnDefinition = "geography")
    private Object deliveryLocation;
*/
}