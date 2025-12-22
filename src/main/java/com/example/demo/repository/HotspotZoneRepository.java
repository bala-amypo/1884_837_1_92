package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HotspotZone;

import java.util.List;
import java.util.Optional;

public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {

    Optional<HotspotZone> findByZoneName(String zoneName);

    List<HotspotZone> findBySeverityLevel(String level);

    boolean existsByZoneName(String zoneName);
}
