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
}
