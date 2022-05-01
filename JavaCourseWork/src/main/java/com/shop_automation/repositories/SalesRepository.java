package com.shop_automation.repositories;

import com.shop_automation.dto.OrderResponse;
import com.shop_automation.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    //SELECT s, w FROM Sales s, Warehouses w JOIN w ON w.name = 'Яблоки'

    @Query("SELECT new com.shop_automation.dto.OrderResponse(s.quantity, w.quantity) FROM Sales s JOIN s.warehouses w WHERE w.name = ?1")
    List<OrderResponse> getJoinInformation(String src);
}
