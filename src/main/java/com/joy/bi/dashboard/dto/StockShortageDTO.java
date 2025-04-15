package com.joy.bi.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// 3. Stock Shortage
@Data @AllArgsConstructor
public class StockShortageDTO {
    private String itemName;
    private int quantityOnHand;
    private int reorderLevel;
    private int targetStockLevel;
    private int shortage;
}
