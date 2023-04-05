package com.saru.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address_line1",unique = false,nullable = false,length = 500)
    private String addressLine1;

    @Column(name = "address_line2",unique = false,nullable = true,length = 500)
    private String addressLine2;

    @Column(name = "city",unique = false,nullable = false,length = 500)
    private String city;

    @Column(name = "state",unique = false,nullable = false,length = 500)
    private String state;

    @Column(name = "zipcode",unique = false,nullable = false,length = 500)
    private String zipCode;

    @Column(name = "country",unique = false,nullable = false,length = 500)
    private String country;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
