package com.springmp.springmp.dto;


import com.springmp.springmp.validator.UniqueUserName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UserCreateDTO {

    @NotNull(message = "{backend.constraints.userName.notNull.message}")
    @Size(min=4, max=32,message = "{backend.constraints.userName.Size.message}")
    @UniqueUserName
    private String userName;

    @NotNull(message = "{backend.constraints.firstName.notNull.message}")
    @Size(min=4, max=32, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.notNull.message}")
    @Size(min=3, max=32, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

}
