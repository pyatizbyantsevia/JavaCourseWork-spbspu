package com.shop_automation.repositories.db;

import com.shop_automation.models.db.ExpenseItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseItemsRepository extends JpaRepository<ExpenseItems, Long> {

}
