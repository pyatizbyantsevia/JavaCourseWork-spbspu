package com.shop_automation.repositories;

import com.shop_automation.dto.SaleResponse;
import com.shop_automation.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT new com.shop_automation.dto.OrderResponse(s.quantity, w.quantity) FROM Sales s JOIN s.warehouses w WHERE w.name = ?1")
    List<SaleResponse> getJoinInformation(String src);
}
