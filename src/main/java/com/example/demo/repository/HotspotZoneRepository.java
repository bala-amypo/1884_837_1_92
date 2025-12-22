package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.entity.*;

public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {
    Optional<HotspotZone> findByZoneName(String name);
    boolean existsByZoneName(String name);
    List<HotspotZone> findBySeverityLevel(String severity);
}
