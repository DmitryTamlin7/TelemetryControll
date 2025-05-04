package com.spacetech.telemetry.controller;

import com.spacetech.telemetry.model.TelemetryData;
import com.spacetech.telemetry.service.TelemetryService;
import com.sun.net.httpserver.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService service;

    @PostMapping
    public ResponseEntity<TelemetryData> receiveTelemetry(@RequestBody TelemetryData data) {
        TelemetryData saved = service.save(data);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<TelemetryData>> getAllTelemetry() {
        List<TelemetryData> allData = service.fundAll();
        return ResponseEntity.ok(allData);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<TelemetryData>> filter(
            @RequestParam(required = false) String sensorId,
            @RequestParam(required = false) Instant from,
            @RequestParam(required = false) Instant to,
            @RequestParam(required = false) Double minValue,
            @RequestParam(required = false) Double maxValue
    ) {
        return ResponseEntity.ok(service.filter(sensorId, from, to, minValue, maxValue));
    }

}




