package com.example.demo.service.impl;

import com.example.demo.entity.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import com.example.demo.util.CoordinateValidator;
import com.example.demo.util.DateValidator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    private final CrimeReportRepository repo;

    public CrimeReportServiceImpl(CrimeReportRepository repo) {
        this.repo = repo;
    }

    public CrimeReport addReport(CrimeReport r) {
        if (r.getLatitude() > 90 || r.getLatitude() < -90)
            throw new RuntimeException("Invalid latitude");
        return repo.save(r);
    }

    public List<CrimeReport> getAllReports() {
        return repo.findAll();
    }
}
