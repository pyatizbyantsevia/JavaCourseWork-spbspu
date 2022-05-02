package com.shop_automation.controllers;

import com.shop_automation.dto.SaleRequest;
import com.shop_automation.dto.SaleResponse;
import com.shop_automation.models.Sales;
import com.shop_automation.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("get-all")
    public ModelAndView getSales(Map<String, Object> model) {
        List<Sales> salesList = salesService.getSales();
        model.put("sales", salesList);
        model.put("title", "<<Sales>>");
        return new ModelAndView("sales", model);
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
