package com.shop_automation.controllers;

import com.shop_automation.dto.WarehouseDTO;
import com.shop_automation.dto.WarehouseRequest;
import com.shop_automation.handlers.Response;
import com.shop_automation.models.Warehouses;
import com.shop_automation.services.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("warehouses-controller")
public class WarehousesController {

    private final WarehousesService warehousesService;

    @Autowired
    public WarehousesController(WarehousesService warehousesService) {
        this.warehousesService = warehousesService;
    }

    @GetMapping("main")
    public String getAllWarehouses(Map<String, Object> model) {
        List<Warehouses> response = warehousesService.getWarehouses();
        List<WarehouseDTO> temp = new ArrayList<>();
        for (Warehouses warehouses : response) {
            temp.add(new WarehouseDTO(
                    warehouses.getId(),
                    warehouses.getName(),
                    warehouses.getQuantity(),
                    warehouses.getAmount()
            ));
        }
        model.put("warehouses", temp);
        return "warehouses";
    }

    @PostMapping(path = "main", params = "btnAdd")
    public String addGoods(
            @RequestParam String name,
            @RequestParam Double amount,
            @RequestParam Integer quantity,
            Map<String, Object> model) {
        String result = warehousesService.saveWarehouse(new WarehouseRequest(name, quantity, amount));
        Response response = new Response(result);
        model.put("responseAdd", response);
        return getAllWarehouses(model);
    }

    @PostMapping(path = "main", params = "btnReplenish")
    public String updateGoods(
            @RequestParam String name,
            @RequestParam Integer quantity,
            Map<String, Object> model) {
        String result = warehousesService.addGoods(new WarehouseRequest(name, quantity));
        Response response = new Response(result);
        model.put("responseUpdate", response);
        return getAllWarehouses(model);
    }

    @PostMapping(path = "main", params = "btnDelete")
    public String cascadeDelete(@RequestParam Long id,
                                Map<String, Object> model) {
        String result = warehousesService.cascadeDelete(id);
        Response response = new Response(result);
        model.put("responseDelete", response);
        return getAllWarehouses(model);
    }

}
