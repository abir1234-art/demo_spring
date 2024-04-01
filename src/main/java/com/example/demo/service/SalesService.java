package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Sale;

import java.util.List;

@Service
public class SalesService {

    private final SaleRepository saleRepository;

    @Autowired
    public SalesService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public Sale saveSale(Sale sale) {
        // Additional business logic/validation can be added here before saving
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale saleDetails) {
        Sale existingSale = saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", id));

        // Update existingSale with saleDetails
        existingSale.setClient(saleDetails.getClient());
        existingSale.setSeller(saleDetails.getSeller());
        existingSale.setTotal(saleDetails.getTotal());
        // Additional fields to update...

        // Save updated sale
        return saleRepository.save(existingSale)
