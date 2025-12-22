package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository crimeRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(
            HotspotZoneRepository zoneRepo,
            CrimeReportRepository crimeRepo,
            PatternDetectionResultRepository resultRepo,
            AnalysisLogRepository logRepo) {

        this.zoneRepo = zoneRepo;
        this.crimeRepo = crimeRepo;
        this.resultRepo = resultRepo;
        this.logRepo = logRepo;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {

        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found"));

        double lat = zone.getCenterLat();
        double lng = zone.getCenterLong();

        List<CrimeReport> crimes = crimeRepo.findByLatLongRange(
                lat - 0.1, lat + 0.1,
                lng - 0.1, lng + 0.1
        );

        int count = crimes.size();
        String pattern;

        if (count > 5) {
            pattern = "High crime activity";
            zone.setSeverityLevel("HIGH");
        } else if (count > 0) {
            pattern = "Medium crime activity";
            zone.setSeverityLevel("MEDIUM");
        } else {
            pattern = "No crime activity";
            zone.setSeverityLevel("LOW");
        }

        zoneRepo.save(zone);

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setAnalysisDate(LocalDate.now());
        result.setCrimeCount(count);
        result.setDetectedPattern(pattern);

        resultRepo.save(result);

        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern detection executed");
        logRepo.save(log);

        return result;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
