package com.springmp.springmp.dto.userDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Kullanıcıları güncellemek için verileri transfer eder.
 */
@Data
public class UserUpdateDTO {

    @NotNull(message = "{backend.constraints.firstName.notNull.message}")
    @Size(min=4, max=32, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.notNull.message}")
    @Size(min=3, max=32, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

}
