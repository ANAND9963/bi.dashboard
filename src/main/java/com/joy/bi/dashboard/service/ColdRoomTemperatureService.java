package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.ColdRoomTemperatureDTO;
import com.joy.bi.dashboard.repository.ColdRoomTemperatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColdRoomTemperatureService {

    private final ColdRoomTemperatureRepository repository;

    public ColdRoomTemperatureService(ColdRoomTemperatureRepository repository) {
        this.repository = repository;
    }

    public List<ColdRoomTemperatureDTO> getColdRoomTemperatures() {
        return repository.getColdRoomTemperatureStats()
                .stream()
                .map(row -> new ColdRoomTemperatureDTO(
                        (Integer) row[0],
                        row[1].toString(),
                        ((Number) row[2]).doubleValue(),
                        ((Number) row[3]).doubleValue(),
                        ((Number) row[4]).doubleValue()
                ))
                .collect(Collectors.toList());
    }
}