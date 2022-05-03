package com.shop_automation.repositories;

import com.shop_automation.models.Sales;
import com.shop_automation.models.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, Long> {

    Optional<Warehouses> findByName(String name);
}
