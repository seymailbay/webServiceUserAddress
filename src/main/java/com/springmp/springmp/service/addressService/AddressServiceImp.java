package com.springmp.springmp.service.addressService;

import com.springmp.springmp.dto.addressDTO.AddressCreateDTO;
import com.springmp.springmp.dto.addressDTO.AddressUpdateDTO;
import com.springmp.springmp.dto.addressDTO.AddressViewDTO;
import com.springmp.springmp.exception.NotFoundException;
import com.springmp.springmp.model.Address;
import com.springmp.springmp.repository.addressRepository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * getAddress(): Bu metod, addressRepository kullanarak tüm adresleri alır ve daha sonra stream ve map fonksiyonlarını kullanarak bunları AddressViewDTO'ya dönüştürür.
 * createAddress(AddressCreateDTO addressCreateDTO): Bu metod, addressRepository kullanarak yeni bir adres oluşturur ve oluşan adresin AddressViewDTO'sunu döndürür.
 * updateAddress(Long id, AddressUpdateDTO addressUpdateDTO): Bu metod, addressRepository örneğini kullanarak id'ye göre adresi alır ve adres ayrıntılarını günceller.
 * Bu güncellenen adres, addressRepository ile kaydedilir ve güncellenen adresin AddressViewDTO'su döndürür.
 * Ayrıca, @Transactional anotasyonu ile birden fazla sorgunun aynı süreçde işlem görmesi gerektiğini gösterir.
 */

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService{
    private final AddressRepository addressRepository;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<AddressViewDTO> getAddress() {
        return addressRepository.findAll().stream().map(AddressViewDTO::of).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public AddressViewDTO createAddress(AddressCreateDTO addressCreateDTO) {
        Address address= addressRepository.save(new Address(addressCreateDTO.getStreet(), addressCreateDTO.getCity()));
        return AddressViewDTO.of(address);
    }

    @Override
    @Transactional
    public AddressViewDTO updateAddress(Long id, AddressUpdateDTO addressUpdateDTO) {
        final Address address = addressRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        address.setStreet(addressUpdateDTO.getStreet());
        address.setCity(addressUpdateDTO.getCity());
        final Address updatedAddress= addressRepository.save(address);
        return AddressViewDTO.of(updatedAddress);
    }

}
