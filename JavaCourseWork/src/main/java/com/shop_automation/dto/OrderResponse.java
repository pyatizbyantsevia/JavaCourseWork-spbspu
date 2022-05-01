package com.shop_automation.dto;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {

    private Integer quantityS;
    private Integer quantityW;
}
