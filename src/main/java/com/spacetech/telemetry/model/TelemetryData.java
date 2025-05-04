package com.spacetech.telemetry.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class TelemetryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String sensorId;
    private Instant timestamp;
    private double sensorvalue;
    private String unit;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return sensorvalue;
    }

    public void setValue(double sensorvalue) {
        this.sensorvalue = sensorvalue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
