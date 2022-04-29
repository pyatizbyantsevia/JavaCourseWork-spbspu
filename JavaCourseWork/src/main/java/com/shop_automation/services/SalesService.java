package com.shop_automation.services;

import com.shop_automation.models.Sales;
import com.shop_automation.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SalesService {

    private final SalesRepository salesRepository;
    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sales> getSales() {
        return salesRepository.findAll();
    }

}
