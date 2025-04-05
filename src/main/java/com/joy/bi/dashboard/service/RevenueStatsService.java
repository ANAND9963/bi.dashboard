package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.model.RevenueStatsDto;
import com.joy.bi.dashboard.repository.RevenueStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueStatsService {

    @Autowired
    private RevenueStatsRepository repository;

    public List<RevenueStatsDto> getStats() {
        return repository.getQuarterlyRevenueStats();
    }
    public List<RevenueStatsDto> getQuarterlyRevenueStats(int startYear, int endYear) {
        return repository.getQuarterlyRevenueStats(startYear, endYear);
    }
}
