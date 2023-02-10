package com.springmp.springmp.api.addressApi;

import com.springmp.springmp.dto.addressDTO.AddressCreateDTO;
import com.springmp.springmp.dto.addressDTO.AddressUpdateDTO;
import com.springmp.springmp.dto.addressDTO.AddressViewDTO;
import com.springmp.springmp.service.addressService.AddressService;
import com.springmp.springmp.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AddressAPI RESTful web servisi oluşturmak için Spring MVC kullanılarak yazılmış bir Java sınıfıdır.
 *@RestController: Bu anotasyon, sınıfın bir RESTful web hizmeti sağladığını belirtir.
 *@RequestMapping("/api"): Bu anotasyon, sınıfın "/api" URL'si ile olan isteklere cevap vermesini sağlar.
 *@RequiredArgsConstructor: Tüm alanlar için bir "constructor" oluşturur. Bu sayede AddressService sınıfının nesnesi, sınıf içinde kullanılmak üzere oluşturulur.
 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AddressAPI {

    /**
     *Bu Controller Sınıfımızın(AddressAPI) amacı model ile view arasındaki iletişimi sağlamaktır.
     * AddressViewDto nesnesi HTTP olarak alınır ve clienta döndürülür.
     * ResponseEntity.ok istek başarılıysa HTTP 200 OK mesajı yaratır.
     * Clienttan gelen requesti alır ve gerekli şekilde kullanır.
     *
     * getAddress(): AddressService sınıfından getAddress() çağırarak tüm adresleri döndürür ve bunları "List<AddressViewDTO>" şeklinde döndürür.
     *
     * createAddress(): Gelen adres oluşturma isteğindeki bilgileri içeren "AddressCreateDTO" nesnesini alır ve AddressService sınıfının createAddress() metotunu çağırarak bu bilgileri kullanarak bir adres oluşturur.
     *
     * updateAddress(): Gelen adres güncelleme isteğindeki bilgileri içeren "AddressUpdateDTO" nesnesini ve adresin güncellenmesi istenen "id" bilgisini alır ve AddressService sınıfından updateAddress() çağırarak bu bilgileri kullanarak bir adres günceller.
     * Güncellenen adres, "AddressViewDTO" şeklinde döndürür.
     */
    private final AddressService addressService;

    @GetMapping("v1/address")
    public ResponseEntity<List<AddressViewDTO>> getAddress(){
        final List<AddressViewDTO> addressViewDTOList =addressService.getAddress();
        return ResponseEntity.ok(addressViewDTOList);
    }

    @PostMapping("v1/address")
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressCreateDTO addressCreateDTO){
        addressService.createAddress(addressCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Address Created"));
    }

    @PutMapping("v1/address/{id}")
    public ResponseEntity<AddressViewDTO> updateAddress(@PathVariable("id") Long id, @RequestBody AddressUpdateDTO addressUpdateDTO){
        final AddressViewDTO address = addressService.updateAddress(id,addressUpdateDTO);
        return ResponseEntity.ok(address);
    }

}
