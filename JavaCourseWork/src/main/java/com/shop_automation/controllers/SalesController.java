package com.shop_automation.controllers;

import com.shop_automation.dto.SaleDTO;
import com.shop_automation.dto.SaleRequest;
import com.shop_automation.handlers.Response;
import com.shop_automation.models.Sales;
import com.shop_automation.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sales-controller")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("main")
    public String getAllSales(Map<String, Object> model) {
        List<Sales> response = salesService.getSales();
        List<SaleDTO> temp = new ArrayList<>();
        for (Sales sales : response) {
            temp.add(new SaleDTO(
                    sales.getId(),
                    sales.getAmount(),
                    sales.getQuantity(),
                    sales.getSale_date(),
                    sales.getWarehouses().getId()
            ));
        }
        model.put("sales", temp);
        return "sales";
    }

    @PostMapping(path = "main", params = "btnAdd")
    public String add(
            @RequestParam Double amount,
            @RequestParam Integer quantity,
            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime local_date,
            @RequestParam Long warehouse_id,
            Map<String, Object> model) {

        String result = salesService.saveSale(new SaleRequest(amount, quantity, local_date, warehouse_id));
        Response response = new Response(result);
        model.put("responseAdd", response);
        return getAllSales(model);
    }

    @PostMapping(path = "main", params = "btnDelete")
    public String delete(
            @RequestParam Long id,
            Map<String, Object> model) {
        String result = salesService.deleteSale(id);
        Response response = new Response(result);
        model.put("responseDelete", response);
        return getAllSales(model);
    }
}
