package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.ColorUsageDTO;
import com.joy.bi.dashboard.repository.ColorStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorWiseItemStatsService {

    private final ColorStatsRepository repository;

    public ColorWiseItemStatsService(ColorStatsRepository repository) {
        this.repository = repository;
    }

    public List<ColorUsageDTO> getColorWiseStats() {
        return repository.findColorStats()
                .stream()
                .map(row -> new ColorUsageDTO(
                        (String) row[0],
                        (long) ((Number) row[1]).intValue(),
                        ((Number) row[2]).doubleValue()
                ))
                .collect(Collectors.toList());
    }
}