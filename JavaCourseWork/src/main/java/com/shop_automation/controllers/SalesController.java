package com.shop_automation.controllers;

import com.shop_automation.dto.SaleRequest;
import com.shop_automation.dto.SaleResponse;
import com.shop_automation.handlers.Response;
import com.shop_automation.models.Sales;
import com.shop_automation.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("get-all")
    public List<Sales> getAllSales(Map<String, Object> model) {
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

    @PostMapping("add-through-http")
    public String registerNewSale(@RequestBody SaleRequest saleRequest) {
        return salesService.saveSale(saleRequest);
    }

    @GetMapping("add-through-mustache")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @PostMapping("add-through-mustache")
    public String add(
            @RequestParam Double amount,
            @RequestParam Integer quantity,
            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime local_date,
            @RequestParam Long warehouse_id,
            Map<String, Object> model) {

        String result = salesService.saveSale(new SaleRequest(amount, quantity, local_date, warehouse_id));
        Response response = new Response(result);
        model.put("response", response);
        return "main";
    }
}
