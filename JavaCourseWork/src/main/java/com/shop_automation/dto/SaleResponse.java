package com.shop_automation.dto;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleResponse {

    private Integer quantitySale;
    private String name;
}
