package com.shop_automation.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Charges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    private LocalDate charge_date;

    @ManyToOne
    @JoinColumn(name = "expense_item_id", foreignKey = @ForeignKey(name = "FK_CHARGES_EXPENSEITEMS"))
    private ExpenseItems expense_items;
}
