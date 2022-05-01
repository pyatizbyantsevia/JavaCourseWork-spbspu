package com.shop_automation.controllers;

import com.shop_automation.dto.OrderResponse;
import com.shop_automation.models.Sales;
import com.shop_automation.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("get-join/{src}")
    public Boolean getJoinInformation(@PathVariable String src) {
        return salesService.getJoinInformation(src);
    }

}
