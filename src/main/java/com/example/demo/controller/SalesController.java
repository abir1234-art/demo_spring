package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Sale;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.findAllSales());
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.createSale(sale));
    }

    // Example endpoint for editing quantities and prices
    @PatchMapping("/{id}")
    public ResponseEntity<Sale> editSale(@PathVariable Long id, @RequestBody Sale saleDetails) {
        return ResponseEntity.ok(saleService.editSale(id, saleDetails));
    }
}
