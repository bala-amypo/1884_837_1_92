package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AnalysisLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    @ManyToOne
    private HotspotZone zone;

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    public AnalysisLog() {}

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
