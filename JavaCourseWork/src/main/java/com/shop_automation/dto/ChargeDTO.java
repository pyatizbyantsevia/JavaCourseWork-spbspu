package com.shop_automation.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChargeDTO {

    private Long id;
    private Double amount;
    private LocalDateTime charge_date;
    private Long expense_item_id;
}
