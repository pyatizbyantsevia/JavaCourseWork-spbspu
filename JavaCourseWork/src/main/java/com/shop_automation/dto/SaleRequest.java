package com.shop_automation.dto;

import com.shop_automation.models.Sales;
import lombok.*;

import java.time.LocalDate;
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
