package com.springmp.springmp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(name = "user_name",nullable = false,length = 50, unique = true) // save database
    private String userName;

    @Column(name="firstName", nullable = false,length = 50)
    private String firstName;

    @Column(name="lastName", nullable = false,length = 50)
    private String lastName;

    public User(String userName,String firstName, String lastName) {
        this.userName=userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
