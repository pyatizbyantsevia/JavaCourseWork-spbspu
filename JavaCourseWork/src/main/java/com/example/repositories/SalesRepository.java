package com.example.repositories;

import com.example.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT s FROM CourseWork s WHERE s.amount = ?1")
    Optional<Sales> findSalesByAmount(Double amount);
}
