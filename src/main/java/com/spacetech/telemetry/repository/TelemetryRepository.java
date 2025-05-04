package com.spacetech.telemetry.repository;

import com.spacetech.telemetry.model.TelemetryData;
import  org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface TelemetryRepository extends JpaRepository<TelemetryData, Long> {

}
