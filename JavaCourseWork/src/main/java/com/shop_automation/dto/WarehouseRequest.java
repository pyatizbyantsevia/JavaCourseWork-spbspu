package com.shop_automation.dto;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarehouseRequest {

    private String name;
    private Integer quantity;
    private Double amount;

    public WarehouseRequest(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public WarehouseRequest(Integer quantity, Double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }
}
