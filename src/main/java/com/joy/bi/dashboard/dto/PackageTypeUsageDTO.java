package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// 5. Package Type Usage
@Data @AllArgsConstructor
public class PackageTypeUsageDTO {
    private String packageTypeName;
    private Long stockItemCount;
}
