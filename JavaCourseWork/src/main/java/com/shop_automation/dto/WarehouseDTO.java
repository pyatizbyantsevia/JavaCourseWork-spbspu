package com.shop_automation.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarehouseDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            return "aboba";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        if (quantity == null) {
            return 2;
        }
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        if (amount == null) {
            return 2.2;
        }
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
