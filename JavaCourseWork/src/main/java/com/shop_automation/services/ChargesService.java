package com.shop_automation.services;

import com.shop_automation.repositories.ChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ChargesService {

    private final ChargesRepository chargesRepository;

    @Autowired
    public ChargesService(ChargesRepository chargesRepository) {
        this.chargesRepository = chargesRepository;
    }
}
