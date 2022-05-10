package com.shop_automation.controllers;

import com.shop_automation.dto.ChargeDTO;
import com.shop_automation.models.db.Charges;
import com.shop_automation.services.db.ChargesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("charges-controller")
public class ChargesController {

    private final ChargesService chargesService;

    public ChargesController(ChargesService chargesService) {
        this.chargesService = chargesService;
    }

    @GetMapping("main")
    public String getAllCharges(Map<String, Object> model) {
        List<Charges> response = chargesService.getCharges();
        List<ChargeDTO> temp = new ArrayList<>();
        for (Charges charges : response) {
            temp.add(new ChargeDTO(
                    charges.getId(),
                    charges.getAmount(),
                    charges.getCharge_date(),
                    charges.getExpense_items().getId()
            ));
        }
        model.put("charges", temp);
        return "charges";
    }
}
