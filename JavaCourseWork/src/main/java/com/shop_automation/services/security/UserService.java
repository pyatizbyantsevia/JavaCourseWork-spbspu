package com.shop_automation.services.security;

import com.shop_automation.models.security.User;
import com.shop_automation.repositories.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String string) {
        return userRepository.findByUsername(string);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
