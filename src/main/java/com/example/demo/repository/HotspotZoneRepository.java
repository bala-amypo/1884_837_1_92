package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {
    boolean existsByZoneName(String zoneName);
    Optional<HotspotZone> findByZoneName(String zoneName);
    List<HotspotZone> findBySeverityLevel(String level);
}
