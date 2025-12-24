package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository reportRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(
            HotspotZoneRepository zoneRepo,
            CrimeReportRepository reportRepo,
            PatternDetectionResultRepository resultRepo,
            AnalysisLogRepository logRepo) {
        this.zoneRepo = zoneRepo;
        this.reportRepo = reportRepo;
        this.resultRepo = resultRepo;
        this.logRepo = logRepo;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("zone"));

        List<CrimeReport> crimes =
                reportRepo.findByLatLongRange(
                        zone.getCenterLat() - 0.1,
                        zone.getCenterLat() + 0.1,
                        zone.getCenterLong() - 0.1,
                        zone.getCenterLong() + 0.1
                );

        int count = crimes.size();
        String pattern = count > 5 ? "High Risk" :
                         count > 0 ? "Medium Risk" : "No Risk";

        zone.setSeverityLevel(
                count > 5 ? "HIGH" :
                count > 0 ? "MEDIUM" : "LOW"
        );
        zoneRepo.save(zone);

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setCrimeCount(count);
        result.setDetectedPattern(pattern);
        result.setAnalysisDate(LocalDate.now());

        resultRepo.save(result);
        logRepo.save(new AnalysisLog("Pattern detection executed", zone));

        return result;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}
