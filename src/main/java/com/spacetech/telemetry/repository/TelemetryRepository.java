package com.spacetech.telemetry.repository;

import com.spacetech.telemetry.model.TelemetryData;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.Instant;
import java.util.List;
import javax.swing.*;


public interface TelemetryRepository extends JpaRepository<TelemetryData, Long> {

    @Query("SELECT t FROM TelemetryData t " +
            "WHERE (:sensorId IS NULL OR t.sensorId = :sensorId) " +
            "AND (:from IS NULL OR t.timestamp >= :from) " +
            "AND (:to IS NULL OR t.timestamp <= :to) " +
            "AND (:minValue IS NULL OR t.sensorvalue >= :minValue) " +
            "AND (:maxValue IS NULL OR t.sensorvalue <= :maxValue)")
    List<TelemetryData> filter(
            @Param("sensorId") String sensorId,
            @Param("from") Instant from,
            @Param("to") Instant to,
            @Param("minValue") Double minValue,
            @Param("maxValue") Double maxValue
    );
}
