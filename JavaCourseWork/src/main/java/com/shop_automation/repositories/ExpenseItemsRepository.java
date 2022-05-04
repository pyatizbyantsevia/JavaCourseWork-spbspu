package com.shop_automation.repositories;

import com.shop_automation.models.ExpenseItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseItemsRepository extends JpaRepository<ExpenseItems, Long> {

}
