package com.shop_automation.services;

import com.shop_automation.dto.WarehouseRequest;
import com.shop_automation.models.Warehouses;
import com.shop_automation.repositories.SalesRepository;
import com.shop_automation.repositories.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@Service
public class WarehousesService {

    private final SalesRepository salesRepository;
    private final WarehousesRepository warehousesRepository;

    @Autowired
    public WarehousesService(SalesRepository salesRepository, WarehousesRepository warehousesRepository) {
        this.salesRepository = salesRepository;
        this.warehousesRepository = warehousesRepository;
    }

    public List<Warehouses> getWarehouses() {
        return warehousesRepository.findAll();
    }

    public Warehouses getWarehouseById(Long id) {
        return warehousesRepository.getById(id);
    }

    public String saveWarehouse(WarehouseRequest warehouseRequest) {

        if (warehousesRepository.findByName(warehouseRequest.getName()).isPresent()) {
            throw new NoSuchElementException("Такой товар уже есть на складе");
        }
        warehousesRepository.save(new Warehouses(
                warehouseRequest.getName(),
                warehouseRequest.getQuantity(),
                warehouseRequest.getAmount(),
                salesRepository.getSalesByName(warehouseRequest.getName())
        ));
        System.out.println("Запись добавлена");
        return "Запись добавлена";
    }
}
