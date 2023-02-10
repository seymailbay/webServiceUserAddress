package com.springmp.springmp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * **
 *  * Bu sınıf users tablosunu JPA kullanarak veritabanına tanımlar.
 *  *User sınıfı ile Address sınıfı arasındaki ilişki tanımlandı.
 *  @OneToOne anotasyonu bu ilişkiyi belirtir ve Userda gerçekleşen her değişikliği Address sınıfına da taşır.
 *  @JoinColunm(name =”Address_ID”) ile iki sınıfı bağlayan sutunun adı belirtilir.
 *  */


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
    public User(String userName,String firstName, String lastName,Address address) {
        this.userName=userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address=address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_ID")
    private Address address;


}
