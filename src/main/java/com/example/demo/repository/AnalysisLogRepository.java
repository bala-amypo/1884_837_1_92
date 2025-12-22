package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.entity.*;

public interface AnalysisLogRepository
        extends JpaRepository<AnalysisLog, Long> {
    List<AnalysisLog> findByZone_Id(Long id);
}
