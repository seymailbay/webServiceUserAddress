package com.springmp.springmp.dto;

import com.springmp.springmp.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {  // including storing state, transmitting data between processes or systems, and creating backups.
    private final String firstName;
    private final String lastName;

    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(User user) {   //Factory method - return an instance of an object  // with the static, we can call method directly without creating an instance
        return new UserViewDTO(user.getFirstName(), user.getLastName());
    }

}
