package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HotspotZone;

import java.util.List;
import java.util.Optional;

public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {

    List<HotspotZone> findBySeverityLevel(String level);

    Optional<HotspotZone> findByZoneName(String zoneName);
}
