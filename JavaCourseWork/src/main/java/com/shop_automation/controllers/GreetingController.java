package com.shop_automation.controllers;

import com.shop_automation.dto.ChargeDTO;
import com.shop_automation.dto.SaleDTO;
import com.shop_automation.dto.WarehouseDTO;
import com.shop_automation.models.db.Charges;
import com.shop_automation.models.db.ExpenseItems;
import com.shop_automation.models.db.Sales;
import com.shop_automation.models.db.Warehouses;
import com.shop_automation.models.security.Role;
import com.shop_automation.models.security.User;
import com.shop_automation.services.db.ChargesService;
import com.shop_automation.services.db.ExpenseItemsService;
import com.shop_automation.services.db.SalesService;
import com.shop_automation.services.db.WarehousesService;
import com.shop_automation.services.security.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    private final UserService userService;
    private final SalesService salesService;
    private final WarehousesService warehousesService;
    private final ChargesService chargesService;
    private final ExpenseItemsService expenseItemsService;

    public GreetingController(UserService userService, SalesService salesService, WarehousesService warehousesService, ChargesService chargesService, ExpenseItemsService expenseItemsService) {
        this.userService = userService;
        this.salesService = salesService;
        this.warehousesService = warehousesService;
        this.chargesService = chargesService;
        this.expenseItemsService = expenseItemsService;
    }

    @GetMapping
    public String greeting(Map<String, Object> model) {
        List<Sales> responseSales = salesService.getSales();
        List<SaleDTO> tempSales = new ArrayList<>();
        for (Sales sales : responseSales) {
            tempSales.add(new SaleDTO(
                    sales.getId(),
                    sales.getAmount(),
                    sales.getQuantity(),
                    sales.getSale_date(),
                    sales.getWarehouses().getId()
            ));
        }
        List<Warehouses> responseWarehouses = warehousesService.getWarehouses();
        List<WarehouseDTO> tempWarehouses = new ArrayList<>();
        for (Warehouses warehouses : responseWarehouses) {
            tempWarehouses.add(new WarehouseDTO(
                    warehouses.getId(),
                    warehouses.getName(),
                    warehouses.getQuantity(),
                    warehouses.getAmount()
            ));
        }
        List<Charges> responseCharges = chargesService.getCharges();
        List<ChargeDTO> tempCharges = new ArrayList<>();
        for (Charges charges : responseCharges) {
            tempCharges.add(new ChargeDTO(
                    charges.getId(),
                    charges.getAmount(),
                    charges.getCharge_date(),
                    charges.getExpense_items().getId()
            ));
        }
        List<ExpenseItems> responseItems = expenseItemsService.getItems();
        model.put("items", responseItems);
        model.put("charges", tempCharges);
        model.put("warehouses", tempWarehouses);
        model.put("sales", tempSales);
        return "greeting";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, Map<String, Object> model) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            model.put("message", "User exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        return "redirect:/login";
    }
}
