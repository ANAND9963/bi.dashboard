package com.joy.bi.dashboard.controller;

import com.joy.bi.dashboard.model.RevenueStatsDto;
import com.joy.bi.dashboard.service.RevenueStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class RevenueStatsController {

    @Autowired
    private RevenueStatsService service;

    @GetMapping("/quarterly")
    public ResponseEntity<List<RevenueStatsDto>> getQuarterlyStats() {
        return ResponseEntity.ok(service.getStats());
    }
}
