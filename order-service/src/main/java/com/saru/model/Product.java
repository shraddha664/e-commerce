package com.saru.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name",nullable = false,unique = true)
    private String productName;

    @Column(name = "unit_price",nullable = false)
    private Double price;

    @Column(name = "product_desc",nullable = false)
    private String description;

    @OneToOne(mappedBy = "product",cascade = CascadeType.REMOVE,orphanRemoval = true,optional = false)
    private Inventory inventory;

    @Column(name = "quantity_added",nullable = false)
    private Integer quantity;

}
