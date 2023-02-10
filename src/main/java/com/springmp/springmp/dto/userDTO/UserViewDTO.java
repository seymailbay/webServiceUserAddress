package com.springmp.springmp.dto.userDTO;

import com.springmp.springmp.model.Address;
import com.springmp.springmp.model.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * Varolan kullanıcıları getirmek için verileri transfer eder.
 */

@Getter
public final class UserViewDTO implements Serializable {
    private final String firstName;
    private final String lastName;
    private Address address;


    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    private UserViewDTO(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address=address;
    }

    public static UserViewDTO of(User user) {
        return new UserViewDTO(user.getFirstName(), user.getLastName());
    }
    public static UserViewDTO ofWithAddress(User user) {
        if(user.getAddress() != null){
            return new UserViewDTO(user.getFirstName(), user.getLastName(), user.getAddress());
        }
        return null;
    }

}
