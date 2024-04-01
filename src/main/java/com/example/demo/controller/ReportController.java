package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public SalesReport getSalesReport(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reportService.generateSalesReport(startDate, endDate);
    }

    @GetMapping("/clients")
    public ClientReport getClientReport() {
        return reportService.generateClientReport();
    }

    @GetMapping("/products")
    public ProductReport getProductReport() {
        return reportService.generateProductReport();
    }
}
