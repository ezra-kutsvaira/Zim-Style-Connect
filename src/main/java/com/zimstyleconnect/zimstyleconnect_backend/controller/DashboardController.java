package com.zimstyleconnect.zimstyleconnect_backend.controller;

import com.zimstyleconnect.zimstyleconnect_backend.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // 🔹 GET /api/dashboard/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getDashboard(@PathVariable Long userId) {
        Map<String, Object> dashboard = dashboardService.getUserDashboard(userId);
        return ResponseEntity.ok(dashboard);
    }
}
