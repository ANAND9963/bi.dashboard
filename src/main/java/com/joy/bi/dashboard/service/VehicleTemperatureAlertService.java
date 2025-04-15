package com.joy.bi.dashboard.service;

import com.joy.bi.dashboard.dto.VehicleTemperatureAlertDTO;
import com.joy.bi.dashboard.repository.VehicleTemperatureAlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleTemperatureAlertService {

    private final VehicleTemperatureAlertRepository repository;

    public VehicleTemperatureAlertService(VehicleTemperatureAlertRepository repository) {
        this.repository = repository;
    }

    public List<VehicleTemperatureAlertDTO> getTemperatureAlerts() {
        return repository.findVehicleTemperatureAlerts()
                .stream()
                .map(row -> new VehicleTemperatureAlertDTO(
                        (String) row[0],
                        row[1].toString(),
                        ((Number) row[2]).doubleValue()
                ))
                .collect(Collectors.toList());
    }
}
