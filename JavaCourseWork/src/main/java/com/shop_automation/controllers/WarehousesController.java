package com.shop_automation.controllers;

import com.shop_automation.dto.SaleRequest;
import com.shop_automation.dto.WarehouseRequest;
import com.shop_automation.models.Sales;
import com.shop_automation.models.Warehouses;
import com.shop_automation.services.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("warehouses")
public class WarehousesController {

    private final WarehousesService warehousesService;

    @Autowired
    public WarehousesController(WarehousesService warehousesService) {
        this.warehousesService = warehousesService;
    }

    @GetMapping("get-all")
    public List<Warehouses> getAllSales(Map<String, Object> model) {
        return warehousesService.getWarehouses();
    }

    @GetMapping("get-id/{id}")
    public Warehouses findById(@PathVariable long id) {
        return warehousesService.getWarehouseById(id);
    }

    @PostMapping("add-through-http")
    public String registerNewWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
        return warehousesService.saveWarehouse(warehouseRequest);
    }
}
