package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {
    @Query("SELECT c FROM CrimeReport c WHERE c.latitude BETWEEN ?1 AND ?2 AND c.longitude BETWEEN ?3 AND ?4")
    List<CrimeReport> findByLatLongRange(double minLat,double maxLat,double minLong,double maxLong);
}
