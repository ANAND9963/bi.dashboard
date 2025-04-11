package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierContactDTO {
    private String supplierName;
    private String contactPerson;
    private String emailAddress;
    private String phoneNumber;
}