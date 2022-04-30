package com.shop_automation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Warehouses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @OneToMany(mappedBy = "warehouses")
    private List<Sales> salesList;

    private String name;
    private Integer quantity;
    private Double amount;

    @Override
    public String toString() {
        return "Warehouses{" +
                "id=" + id +
                ", salesList=" + salesList +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
