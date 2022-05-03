package com.shop_automation.controllers;

import com.shop_automation.dto.SaleRequest;
import com.shop_automation.handlers.Response;
import com.shop_automation.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("sales-controller")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
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
