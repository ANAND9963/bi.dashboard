package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.model.RevenueStatsDto;
import com.joy.bi.dashboard.service.RevenueStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class RevenueStatsController {

    @Autowired
    private RevenueStatsService service;

    @GetMapping("/quarterly")
    public List<RevenueStatsDto> getQuarterlyStats(
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) Integer endYear
    ) {
        if (startYear != null && endYear != null) {
            return service.getQuarterlyRevenueStats(startYear, endYear);
        } else {
            return service.getStats();
        }
    }

}
