package com.shop_automation.services;


import com.shop_automation.repositories.ExpenseItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ExpenseItemsService {

    private final ExpenseItemsRepository expenseItemsRepository;

    @Autowired
    public ExpenseItemsService(ExpenseItemsRepository expenseItemsRepository) {
        this.expenseItemsRepository = expenseItemsRepository;
    }
}
