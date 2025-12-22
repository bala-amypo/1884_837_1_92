package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.entity.*;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {
    List<CrimeReport> findByLatLongRange(
        Double lat1, Double lat2, Double lon1, Double lon2);
}
