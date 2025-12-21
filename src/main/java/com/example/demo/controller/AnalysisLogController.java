package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs")
@Tag(name = "Analysis Logs")
public class AnalysisLogController {

    private final AnalysisLogService service;

    public AnalysisLogController(AnalysisLogService service) {
        this.service = service;
    }

    @PostMapping("/{zoneId}")
    @Operation(summary = "Add analysis log")
    public AnalysisLog add(@PathVariable Long zoneId,
                           @RequestBody Map<String, String> body) {
        return service.addLog(zoneId, body.get("message"));
    }

    @GetMapping("/zone/{zoneId}")
    @Operation(summary = "Get logs by zone")
    public List<AnalysisLog> logs(@PathVariable Long zoneId) {
        return service.getLogsByZone(zoneId);
    }
}
