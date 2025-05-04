package com.spacetech.telemetry.service;

import com.spacetech.telemetry.model.TelemetryData;
import com.spacetech.telemetry.repository.TelemetryRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import  java.util.List;

@Service
public class TelemetryService {

    private final TelemetryRepository repository;


    public TelemetryService(TelemetryRepository repository) {
        this.repository = repository;
    }

    public TelemetryData save(TelemetryData data){
        return repository.save(data);
    }

    public List<TelemetryData> fundAll() {
        return repository.findAll();
    }

    public List<TelemetryData> filter(String sensorId, Instant from, Instant to, Double minValue, Double maxValue) {
        return repository.filter(sensorId, from, to, minValue, maxValue);
    }



}
