package com.shop_automation.models.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Warehouses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer quantity;
    private Double amount;

    @JsonBackReference
    @OneToMany(mappedBy = "warehouses")
    private List<Sales> salesList;

    public Warehouses(String name, Integer quantity, Double amount, List<Sales> salesList) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
        this.salesList = salesList;
    }
}
