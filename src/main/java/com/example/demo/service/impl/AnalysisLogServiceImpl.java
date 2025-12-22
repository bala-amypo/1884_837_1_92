package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.AnalysisLog;
import com.example.demo.entity.HotspotZone;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.AnalysisLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {

    private final AnalysisLogRepository repo;
    private final HotspotZoneRepository zoneRepo;

    public AnalysisLogServiceImpl(AnalysisLogRepository r, HotspotZoneRepository z){
        repo = r; zoneRepo = z;
    }

    public AnalysisLog addLog(Long zoneId, String msg) {
        HotspotZone z = zoneRepo.findById(zoneId).orElseThrow();
        AnalysisLog l = new AnalysisLog();
        l.setZone(z); l.setMessage(msg);
        return repo.save(l);
    }

    public List<AnalysisLog> getLogsByZone(Long id) {
        return repo.findByZone_Id(id);
    }
}
