package com.shop_automation.configs;

import com.shop_automation.models.Sales;
import com.shop_automation.repositories.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class SalesConfig {

    @Bean
    CommandLineRunner commandLineRunner(SalesRepository repository) {
        return args -> {
            Sales firstSale = new Sales(
                    25.2,
                    5,
                    LocalDate.of(2020, OCTOBER, 2)
            );
            repository.saveAll(
                    List.of(firstSale)
            );
        };
    }
}
