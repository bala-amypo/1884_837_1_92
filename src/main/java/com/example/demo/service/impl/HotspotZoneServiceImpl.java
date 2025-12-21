package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;

import org.springframework.stereotype.Service;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository repository;

    public HotspotZoneServiceImpl(HotspotZoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public HotspotZone addZone(HotspotZone zone) {

        if (repository.findByZoneName(zone.getZoneName()).isPresent()) {
            throw new RuntimeException("Zone already exists");
        }

        if (!CoordinateValidator.isValid(
                zone.getCenterLat(), zone.getCenterLong())) {
            throw new RuntimeException("Invalid latitude or longitude");
        }

        zone.setSeverityLevel("LOW");
        return repository.save(zone);
    }

    @Override
    public java.util.List<HotspotZone> getAllZones() {
        return repository.findAll();
    }
}
