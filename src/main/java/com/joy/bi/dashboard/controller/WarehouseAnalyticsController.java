package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.dto.*;
import com.joy.bi.dashboard.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-analytics")
public class WarehouseAnalyticsController {

    private final TopSellingItemsService topSellingItemsService;
    private final ColdRoomTemperatureService coldRoomTemperatureService;
    private final StockShortageService stockShortageService;
    private final VehicleTemperatureAlertService vehicleTemperatureAlertService;
    private final PackageTypeUsageService packageTypeUsageService;
    private final ColorWiseItemStatsService colorWiseItemStatsService;
    private final StockGroupUsageService stockGroupUsageService;

    public WarehouseAnalyticsController(
            TopSellingItemsService topSellingItemsService,
            ColdRoomTemperatureService coldRoomTemperatureService,
            StockShortageService stockShortageService,
            VehicleTemperatureAlertService vehicleTemperatureAlertService,
            PackageTypeUsageService packageTypeUsageService,
            ColorWiseItemStatsService colorWiseItemStatsService,
            StockGroupUsageService stockGroupUsageService
    ) {
        this.topSellingItemsService = topSellingItemsService;
        this.coldRoomTemperatureService = coldRoomTemperatureService;
        this.stockShortageService = stockShortageService;
        this.vehicleTemperatureAlertService = vehicleTemperatureAlertService;
        this.packageTypeUsageService = packageTypeUsageService;
        this.colorWiseItemStatsService = colorWiseItemStatsService;
        this.stockGroupUsageService = stockGroupUsageService;
    }

    @GetMapping("/top-selling")
    public List<TopSellingItemDTO> getTopSellingItems() {
        return topSellingItemsService.getTopSellingItems();
    }

    @GetMapping("/cold-room-temperatures")
    public List<ColdRoomTemperatureDTO> getColdRoomStats() {
        return coldRoomTemperatureService.getColdRoomTemperatures();
    }

    @GetMapping("/stock-shortages")
    public List<StockShortageDTO> getShortages() {
        return stockShortageService.getShortages();
    }

    @GetMapping("/vehicle-temperature-alerts")
    public List<VehicleTemperatureAlertDTO> getTemperatureAlerts() {
        return vehicleTemperatureAlertService.getTemperatureAlerts();
    }

    @GetMapping("/package-type-usage")
    public List<PackageTypeUsageDTO> getPackageTypeUsage() {
        return packageTypeUsageService.getUsageData();
    }

    @GetMapping("/color-wise-stats")
    public List<ColorUsageDTO> getColorWiseStats() {
        return colorWiseItemStatsService.getColorWiseStats();
    }

    @GetMapping("/stock-group-usage")
    public List<StockGroupUsageDTO> getStockGroupUsage() {
        return stockGroupUsageService.getGroupUsageStats();
    }
}