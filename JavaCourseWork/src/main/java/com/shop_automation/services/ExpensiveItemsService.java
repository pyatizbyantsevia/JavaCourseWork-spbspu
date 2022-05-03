package com.shop_automation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ExpensiveItemsService {

    private final ExpensiveItemsService expensiveItemsService;

    @Autowired
    public ExpensiveItemsService(ExpensiveItemsService expensiveItemsService) {
        this.expensiveItemsService = expensiveItemsService;
    }
}
