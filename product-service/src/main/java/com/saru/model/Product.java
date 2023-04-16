package com.saru.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "sku_code",nullable = false,unique = true)
    private String skuCodes;

    @Column(name = "quantity_added",nullable = false)
    private Integer quantity;

}
