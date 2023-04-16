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

    @Column(name = "quantity_added",nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", unique = true)
    private Cart cart;

    @Column(name = "skuCode",nullable = false,unique = true)
    private String skuCode;

}
