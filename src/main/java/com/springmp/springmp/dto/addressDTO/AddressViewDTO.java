package com.springmp.springmp.dto.addressDTO;

import com.springmp.springmp.model.Address;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class AddressViewDTO implements Serializable {

    /**
     * Verilerin son halini görebilmemiz için
     */

    private final String street;
    private final String city;

    private AddressViewDTO(String street,String city){
        this.street=street;
        this.city=city;
    }

   public static AddressViewDTO of(Address address){
        return new AddressViewDTO(address.getStreet(),address.getCity());
   }

}
