package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository repo;

    public HotspotZoneServiceImpl(HotspotZoneRepository repo) {
        this.repo = repo;
    }

    public HotspotZone addZone(HotspotZone z) {
        if (repo.existsByZoneName(z.getZoneName()))
            throw new RuntimeException("Zone exists");

        if (z.getCenterLat() > 90 || z.getCenterLong() > 180)
            throw new RuntimeException("Invalid latitude or longitude");

        return repo.save(z);
    }

    public List<HotspotZone> getAllZones() {
        return repo.findAll();
    }
}
