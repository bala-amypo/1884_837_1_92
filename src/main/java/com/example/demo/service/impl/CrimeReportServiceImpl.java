package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import com.example.demo.util.CoordinateValidator;
import com.example.demo.util.DateValidator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    private final CrimeReportRepository repository;

    public CrimeReportServiceImpl(CrimeReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {

        if (!CoordinateValidator.isValid(report.getLatitude(), report.getLongitude())) {
            throw new RuntimeException("Invalid latitude or longitude");
        }

        if (!DateValidator.isPastOrPresent(report.getOccurredAt())) {
            throw new RuntimeException("Invalid date");
        }

        return repository.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return repository.findAll();
    }
}
