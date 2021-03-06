package com.shop_automation.services.db;

import com.shop_automation.dto.WarehouseRequest;
import com.shop_automation.models.db.Sales;
import com.shop_automation.models.db.Warehouses;
import com.shop_automation.repositories.db.SalesRepository;
import com.shop_automation.repositories.db.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            return "Такой товар уже есть на складе";
        }
        warehousesRepository.save(new Warehouses(
                warehouseRequest.getName(),
                warehouseRequest.getQuantity(),
                warehouseRequest.getAmount(),
                salesRepository.getSalesByName(warehouseRequest.getName())
        ));
        return "Запись добавлена";
    }

    public String addGoods(WarehouseRequest warehouseRequest) {
        Optional<Warehouses> temp = warehousesRepository.findByName(warehouseRequest.getName());
        if (temp.isPresent()) {
            temp.get().setQuantity(temp.get().getQuantity() + warehouseRequest.getQuantity());
            warehousesRepository.save(temp.get());
            return "Товар пополнен";
        } else {
            return "Имя товара не найдено";
        }
    }

    public void deleteAllSalesByName(String name) {
        List<Sales> temp = salesRepository.getSalesByName(name);
        salesRepository.deleteAll(temp);
    }

    public String cascadeDelete(Long id) {
        Optional<Warehouses> temp = warehousesRepository.findById(id);
        if (temp.isPresent()) {
            List<Sales> salesList = salesRepository.findAll();
            for(Sales i: salesList) {
                if (i.getWarehouses() == temp.get()) {
                    salesRepository.deleteById(i.getId());
                }
            }
            warehousesRepository.deleteById(id);
            return "Oк";
        } else {
            return "Товара с таким id не существует";
        }
    }
}
