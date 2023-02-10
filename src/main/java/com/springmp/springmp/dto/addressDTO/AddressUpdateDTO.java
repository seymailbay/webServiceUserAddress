package com.springmp.springmp.dto.addressDTO;

import lombok.Data;

@Data
public class AddressUpdateDTO {

    /**
     *Güncelleme yapmak için verileri transfer eder.
     */
    private String street;

    private String city;
}
