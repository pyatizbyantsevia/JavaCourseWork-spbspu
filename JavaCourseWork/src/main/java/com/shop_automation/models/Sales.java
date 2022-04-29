package com.shop_automation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double amount;
    private Integer quantity;
    private LocalDate sale_date;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "warehouse_id", foreignKey = @ForeignKey(name = "FK_SALES_WAREHOUSES"))
    private Warehouses warehouses;

    public Sales() {
    }

    public Sales(
            Long id,
            Double amount,
            Integer quantity,
            LocalDate sale_date,
            Warehouses warehouse_id) {
        this.id = id;
        this.amount = amount;
        this.quantity = quantity;
        this.sale_date = sale_date;
        this.warehouses = warehouse_id;
    }

    public Sales(
            Double amount,
            Integer quantity,
            LocalDate sale_date) {
        this.amount = amount;
        this.quantity = quantity;
        this.sale_date = sale_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }

    public Warehouses getWarehouse_id() {
        return warehouses;
    }

    public void setWarehouse_id(Warehouses warehouse_id) {
        this.warehouses = warehouse_id;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", amount=" + amount +
                ", quantity=" + quantity +
                ", sale_date=" + sale_date +
                ", warehouses=" + warehouses +
                '}';
    }
}
