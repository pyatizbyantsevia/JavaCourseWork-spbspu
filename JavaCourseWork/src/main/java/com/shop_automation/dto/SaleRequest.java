package com.shop_automation.dto;

import com.shop_automation.models.Sales;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleRequest {

    private Double amount;
    private Integer quantity;
    private LocalDate sale_date;
    private Long warehouse_id;
}
