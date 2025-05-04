package com.spacetech.telemetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class TelemetryCollectorApplication {
    public static void main(String[] args){
        SpringApplication.run(TelemetryCollectorApplication.class, args);
    }

}
