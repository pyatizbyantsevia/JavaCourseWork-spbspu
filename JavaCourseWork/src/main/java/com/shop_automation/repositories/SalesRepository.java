package com.shop_automation.repositories;

import com.shop_automation.dto.SaleResponse;
import com.shop_automation.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT new com.shop_automation.dto.SaleResponse(s.quantity, w.name) FROM Sales s JOIN s.warehouses w WHERE s.sale_date = ?1")
    List<SaleResponse> getQuantityAndNameByDate(LocalDateTime src);

    @Query("SELECT s FROM Sales s JOIN s.warehouses w WHERE w.name = ?1")
    List<Sales> getSalesByName(String src);
}
