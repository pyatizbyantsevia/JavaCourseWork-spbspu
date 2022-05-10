package com.shop_automation.services.db;


import com.shop_automation.models.db.ExpenseItems;
import com.shop_automation.repositories.db.ExpenseItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ExpenseItemsService {

    private final ExpenseItemsRepository expenseItemsRepository;

    @Autowired
    public ExpenseItemsService(ExpenseItemsRepository expenseItemsRepository) {
        this.expenseItemsRepository = expenseItemsRepository;
    }

    public List<ExpenseItems> getItems() {
        return expenseItemsRepository.findAll();
    }
}
