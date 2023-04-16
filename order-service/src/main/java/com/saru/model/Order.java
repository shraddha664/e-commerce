package com.saru.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "order_placed_date",nullable = false)
    private LocalDateTime orderDate;

//todo: implement order status

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
