package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.entity.*;

public interface PatternDetectionResultRepository
        extends JpaRepository<PatternDetectionResult, Long> {
    List<PatternDetectionResult> findByZone_Id(Long id);
}
