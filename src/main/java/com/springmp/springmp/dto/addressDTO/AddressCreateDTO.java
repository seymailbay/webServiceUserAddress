package com.springmp.springmp.dto.addressDTO;

import lombok.Data;

@Data
public class AddressCreateDTO {

    /**
     * Yeni bir adres yaratmak için verileri transfer eder.
     */
    private String street;

    private String city;

}
