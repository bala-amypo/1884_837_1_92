package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class AnalysisLog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime loggedAt = LocalDateTime.now();

    @ManyToOne
    private HotspotZone zone;
}
