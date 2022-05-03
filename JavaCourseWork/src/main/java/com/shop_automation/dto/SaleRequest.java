package com.shop_automation.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleRequest {

    private Double amount;
    private Integer quantity;
    private LocalDateTime sale_date;
    private Long warehouse_id;
}
