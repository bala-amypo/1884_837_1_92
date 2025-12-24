package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface AnalysisLogRepository extends JpaRepository<AnalysisLog, Long> {
    List<AnalysisLog> findByZone_Id(Long zoneId);
}
