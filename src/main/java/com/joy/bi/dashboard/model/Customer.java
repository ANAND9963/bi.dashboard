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
@Table(name = "Customers", schema = "Sales")
public class Customer {
    @Id
    @ColumnDefault("NEXT VALUE FOR [Sequences].[CustomerID]")
    @Column(name = "CustomerID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "CustomerName", nullable = false, length = 100)
    private String customerName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BillToCustomerID", nullable = false)
    private Customer billToCustomerID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerCategoryID", nullable = false)
    private CustomerCategory customerCategoryID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BuyingGroupID")
    private BuyingGroup buyingGroupID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PrimaryContactPersonID", nullable = false)
    private com.joy.bi.dashboard.model.Person primaryContactPersonID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AlternateContactPersonID")
    private com.joy.bi.dashboard.model.Person alternateContactPersonID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DeliveryMethodID", nullable = false)
    private com.joy.bi.dashboard.model.DeliveryMethod deliveryMethodID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DeliveryCityID", nullable = false)
    private City deliveryCityID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PostalCityID", nullable = false)
    private City postalCityID;

    @Column(name = "CreditLimit", precision = 18, scale = 2)
    private BigDecimal creditLimit;

    @Column(name = "AccountOpenedDate", nullable = false)
    private LocalDate accountOpenedDate;

    @Column(name = "StandardDiscountPercentage", nullable = false, precision = 18, scale = 3)
    private BigDecimal standardDiscountPercentage;

    @Column(name = "IsStatementSent", nullable = false)
    private Boolean isStatementSent = false;

    @Column(name = "IsOnCreditHold", nullable = false)
    private Boolean isOnCreditHold = false;

    @Column(name = "PaymentDays", nullable = false)
    private Integer paymentDays;

    @Nationalized
    @Column(name = "PhoneNumber", nullable = false, length = 20)
    private String phoneNumber;

    @Nationalized
    @Column(name = "FaxNumber", nullable = false, length = 20)
    private String faxNumber;

    @Nationalized
    @Column(name = "DeliveryRun", length = 5)
    private String deliveryRun;

    @Nationalized
    @Column(name = "RunPosition", length = 5)
    private String runPosition;

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
    private com.joy.bi.dashboard.model.Person lastEditedBy;

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