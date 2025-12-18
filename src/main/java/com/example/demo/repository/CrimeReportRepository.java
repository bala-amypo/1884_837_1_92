package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.CrimeReport;

import java.util.List;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {

    @Query("""
        SELECT c FROM CrimeReport c
        WHERE c.latitude BETWEEN :minLat AND :maxLat
        AND c.longitude BETWEEN :minLong AND :maxLong
    """)
    List<CrimeReport> findByLatLongRange(
            double minLat,
            double maxLat,
            double minLong,
            double maxLong
    );
}
