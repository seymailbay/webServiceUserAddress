package com.springmp.springmp.repository.addressRepository;

import com.springmp.springmp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository,CRUD işlemleri (oluşturma, okuma, güncelleme ve silme) sağlar.
 * AddressRepository kullanacağı nesnenin tipini ve kullanacağı tipi söyler("Address" ve "Long)".
 */

public interface AddressRepository extends JpaRepository<Address,Long> {
    //boolean existsAddressByCityAnd(String city);
}
