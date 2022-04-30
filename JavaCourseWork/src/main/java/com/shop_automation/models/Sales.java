package com.shop_automation.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    private Integer quantity;
    private LocalDate sale_date;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "warehouse_id", foreignKey = @ForeignKey(name = "FK_SALES_WAREHOUSES"))
    private Warehouses warehouses;

    public Sales(
            Double amount,
            Integer quantity,
            LocalDate sale_date,
            Warehouses warehouses) {
        this.amount = amount;
        this.quantity = quantity;
        this.sale_date = sale_date;
        this.warehouses = warehouses;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", amount=" + amount +
                ", quantity=" + quantity +
                ", sale_date=" + sale_date +
                ", warehouses=" + warehouses +
                '}';
    }
}
