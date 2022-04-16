package com.example.controllers;

import com.example.models.Sales;
import com.example.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public List<Sales> getSales() {
        return salesService.getSales();
    }

    @PostMapping
    public void registerNewSale(@RequestBody Sales sales) {
        salesService.addNewSale(sales);
    }
}
