package com.shop_automation.controllers;

import com.shop_automation.models.security.Role;
import com.shop_automation.models.security.User;
import com.shop_automation.services.security.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class GreetingController {

    private final UserService userService;

    public GreetingController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String greeting(Map<String, Object> model) {
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
