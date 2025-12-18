package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AnalysisLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime loggedAt;

    @ManyToOne
    private HotspotZone zone;

    @PrePersist
    public void onLog() {
        this.loggedAt = LocalDateTime.now();
    }

    public AnalysisLog() {}

    public Long getId() { return id; }
    public String getMessage() { return message; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
    public HotspotZone getZone() { return zone; }

    public void setId(Long id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setZone(HotspotZone zone) { this.zone = zone; }
}
