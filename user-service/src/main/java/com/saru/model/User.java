package com.saru.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name",unique = true,nullable = false,length = 200)
    private String userName;

    @Column(name = "password",unique = false,nullable = false,length = 200)
    private String password;

    @Column(name = "first_name",unique = false,nullable = false,length = 200)
    private String firstName;

    @Column(name = "last_name",unique = false,nullable = false,length = 200)
    private String lastName;

    @Column(name = "email",unique = true,nullable = false,length = 200)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    @Column(name = "phone_number",unique = false,nullable = true,length = 20)
    private String phoneNumber;

}
