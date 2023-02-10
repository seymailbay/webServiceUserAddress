package com.springmp.springmp.service.addressService;

import com.springmp.springmp.dto.addressDTO.AddressCreateDTO;
import com.springmp.springmp.dto.addressDTO.AddressUpdateDTO;
import com.springmp.springmp.dto.addressDTO.AddressViewDTO;

import java.util.List;


/**
 * AddressService CRUD operasyonlarının yapıldığı bir interface olarak arabirim görevi görerek çalışır.
 * Adresleri kaydededen,güncelleyen,getiren soyut metotlara sahiptir.
 * Bu metotlar AddressServiceImp classında içeriğini doldurulur ve davranış verilir.
 */


public interface AddressService {

    List<AddressViewDTO> getAddress();
    AddressViewDTO createAddress(AddressCreateDTO addressCreateDTO);
    AddressViewDTO updateAddress(Long id, AddressUpdateDTO addressUpdateDTO);

}
