package com.shop_automation.repositories;

import com.shop_automation.models.Sales;
import com.shop_automation.models.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, Long> {
}
