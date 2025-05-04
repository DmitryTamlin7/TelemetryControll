package com.spacetech.telemetry.service;


import com.spacetech.telemetry.model.TelemetryData;
import com.spacetech.telemetry.repository.TelemetryRepository;
import org.springframework.stereotype.Service;
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


}
