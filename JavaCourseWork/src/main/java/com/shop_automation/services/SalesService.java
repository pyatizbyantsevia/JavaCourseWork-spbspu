package com.shop_automation.services;

import com.shop_automation.dto.SaleRequest;
import com.shop_automation.dto.SaleResponse;
import com.shop_automation.models.Sales;
import com.shop_automation.models.Warehouses;
import com.shop_automation.repositories.SalesRepository;
import com.shop_automation.repositories.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@Service
public class SalesService {

    private final SalesRepository salesRepository;
    private final WarehousesRepository warehousesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository, WarehousesRepository warehousesRepository) {
        this.salesRepository = salesRepository;
        this.warehousesRepository = warehousesRepository;
    }

    public List<Sales> getSales() {
        return salesRepository.findAll();
    }

    public Sales getSaleById(Long id) {
        return salesRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Элемент не найден"));
    }

    public List<SaleResponse> getQuantityAndNameByDate(String src) {
        return salesRepository.getQuantityAndNameByDate(LocalDateTime.parse(src));
    }

    public String saveSale(SaleRequest saleRequest) {

        Warehouses tempWarehouses = warehousesRepository.findById(saleRequest.getWarehouse_id())
                .orElseThrow(() -> new NoSuchElementException("Товара с указанным id на складе не найдено"));

        if (tempWarehouses.getQuantity() >= saleRequest.getQuantity())
        {
            tempWarehouses.setQuantity(tempWarehouses.getQuantity() - saleRequest.getQuantity());
            salesRepository.save(new Sales(
                    saleRequest.getAmount(),
                    saleRequest.getQuantity(),
                    saleRequest.getSale_date(),
                    warehousesRepository.findById(saleRequest.getWarehouse_id()).get()
            ));
            return "Запись добавлена";
        } else {
            return "На складе недостаточно товара";
        }
    }

    public String deleteSale(Long id) {
        Optional<Sales> temp = salesRepository.findById(id);
        if (temp.isPresent()) {
            salesRepository.deleteById(id);
            return "Oк";
        } else {
            return "Записи с таким id не существует";
        }
    }

    public List<Sales> getSalesByWarehouseAmount() {
        return salesRepository.getSalesByWarehouseAmount();
    }
}
