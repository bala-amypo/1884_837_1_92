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
    private final CrimeReportRepository reportRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(
        HotspotZoneRepository z,
        CrimeReportRepository r,
        PatternDetectionResultRepository p,
        AnalysisLogRepository l) {

        zoneRepo = z; reportRepo = r; resultRepo = p; logRepo = l;
    }

    public PatternDetectionResult detectPattern(Long zoneId) {

        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        int count = reportRepo.findByLatLongRange(0.0,1.0,0.0,1.0).size();

        PatternDetectionResult res = new PatternDetectionResult();
        res.setCrimeCount(count);
        res.setZone(zone);
        res.setDetectedPattern(
            count > 5 ? "HIGH RISK" : count > 2 ? "MEDIUM RISK" : "NO RISK");

        logRepo.save(new AnalysisLog(){{
            setZone(zone); setMessage("Pattern detected");
        }});

        return resultRepo.save(res);
    }

    public List<PatternDetectionResult> getResultsByZone(Long id) {
        return resultRepo.findByZone_Id(id);
    }
}
