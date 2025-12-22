package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class PatternDetectionResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer crimeCount;
    private String detectedPattern;
    private LocalDate analysisDate = LocalDate.now();

    @ManyToOne
    private HotspotZone zone;
}
