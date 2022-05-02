package com.shop_automation.controllers;

import com.shop_automation.dto.SaleRequest;
import com.shop_automation.dto.SaleResponse;
import com.shop_automation.models.Sales;
import com.shop_automation.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("get-all")
    public List<Sales> getSales() {
        return salesService.getSales();
    }

    @GetMapping("get-id/{id}")
    public Sales findById(@PathVariable long id) {
        return salesService.getSaleById(id);
    }

    @GetMapping("get-quantity-and-name/{src}")
    public List<SaleResponse> getQuantityAndNameByDate(@PathVariable String src) {
        return salesService.getQuantityAndNameByDate(src);
    }

    @PostMapping("register-new-sale")
    public String registerNewSale(@RequestBody SaleRequest saleRequest) {
        return salesService.saveSale(saleRequest);
    }
}
