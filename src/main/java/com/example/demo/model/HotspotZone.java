package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "zoneName"))
public class HotspotZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;
    private Double centerLat;
    private Double centerLong;
    private String severityLevel;

    public HotspotZone() {}

    public Long getId() { return id; }
    public String getZoneName() { return zoneName; }
    public Double getCenterLat() { return centerLat; }
    public Double getCenterLong() { return centerLong; }
    public String getSeverityLevel() { return severityLevel; }

    public void setId(Long id) { this.id = id; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
    public void setCenterLat(Double centerLat) { this.centerLat = centerLat; }
    public void setCenterLong(Double centerLong) { this.centerLong = centerLong; }
    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }
}
