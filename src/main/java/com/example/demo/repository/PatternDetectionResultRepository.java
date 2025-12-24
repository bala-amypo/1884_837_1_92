package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface PatternDetectionResultRepository extends JpaRepository<PatternDetectionResult, Long> {
    List<PatternDetectionResult> findByZone_Id(Long zoneId);
}
