package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class HotspotZone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;
    private Double centerLat;
    private Double centerLong;
    private String severityLevel = "LOW";
}
