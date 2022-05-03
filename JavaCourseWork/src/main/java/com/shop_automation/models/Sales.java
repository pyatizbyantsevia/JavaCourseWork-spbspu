package com.shop_automation.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Integer quantity;
    private LocalDateTime sale_date;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", foreignKey = @ForeignKey(name = "FK_SALES_WAREHOUSES"))
    private Warehouses warehouses;

    public Sales(
            Double amount,
            Integer quantity,
            LocalDateTime sale_date,
            Warehouses warehouses) {
        this.amount = amount;
        this.quantity = quantity;
        this.sale_date = sale_date;
        this.warehouses = warehouses;
    }

}
