package com.example.models;

import javax.persistence.*;
import java.time.LocalDate;
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
}
