package com.spacetech.telemetry.simulator;

import com.spacetech.telemetry.model.TelemetryData;
import com.spacetech.telemetry.service.TelemetryService;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.util.Random;

@Component
public class TelemetrySimulator {

    private final TelemetryService telemetryService;
    private final Random random = new Random();

    public  TelemetrySimulator(TelemetryService telemetryService){
        this.telemetryService = telemetryService;
    }

    @PostConstruct
    public void init(){
        System.out.println("telemetry start simulate");
    }

    @Scheduled(fixedDelay = 3000)
    public void  generationdata() {
        TelemetryData date = new TelemetryData();
        date.setSensorId("Sensor" + (random.nextInt(5)+1));
        date.setTimestamp(Instant.now());
        date.setValue(0.01 + (10 - 0.1) * random.nextDouble());
        date.setUnit("m/s²");

        telemetryService.save(date);
        System.out.println("Generate data Succces");
    }




}
