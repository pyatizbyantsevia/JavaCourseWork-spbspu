package com.shop_automation.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarehouseDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private Double amount;
}
