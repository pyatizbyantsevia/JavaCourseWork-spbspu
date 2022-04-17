package com.shop_automation.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Warehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "warehouses")
    private List<Sales> salesList;

    private String name;
    private Integer quantity;
    private Double amount;

    public Warehouses() {
    }

    public Warehouses(Long id, String name, Integer quantity, Double amount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Warehouses(String name, Integer quantity, Double amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
