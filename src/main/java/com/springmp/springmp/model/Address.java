package com.springmp.springmp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bu sınıf address tablosunu JPA kullanarak veritabanına tanımlar.
 *
 */

@Data
@NoArgsConstructor
@Table(name="address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "city",nullable = false)
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}
