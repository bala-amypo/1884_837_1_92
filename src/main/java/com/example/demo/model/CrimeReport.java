package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class CrimeReport {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crimeType;
    private String description;
    private Double latitude;
    private Double longitude;
    private LocalDateTime occurredAt = LocalDateTime.now();
}
