package com.shop_automation.controllers;

import com.shop_automation.models.db.ExpenseItems;
import com.shop_automation.services.db.ExpenseItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("expense-items-controller")
public class ExpenseItemsController {
    private final ExpenseItemsService expenseItemsService;

    public ExpenseItemsController(ExpenseItemsService expenseItemsService) {
        this.expenseItemsService = expenseItemsService;
    }

    @GetMapping("main")
    public String getAllItems(Map<String, Object> model) {
        List<ExpenseItems> temp = expenseItemsService.getItems();
        model.put("items", temp);
        return "items";
    }
}
