package com.springmp.springmp.api.userApi;

import com.springmp.springmp.dto.userDTO.UserCreateDTO;
import com.springmp.springmp.dto.userDTO.UserUpdateDTO;
import com.springmp.springmp.dto.userDTO.UserViewDTO;
import com.springmp.springmp.service.userService.UserService;
import com.springmp.springmp.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    /**
     *Bu Controller Sınıfımızın (userAPI) amacı model ile view arasındaki iletişimi sağlamaktır.
     * UserViewDto nesnesi HTTP olarak alınır ve clienta döndürülür.
     * ResponseEntity.ok istek başarılıysa HTTP 200 OK mesajı yaratır.
     * Clienttan gelen requesti alır ve gerekli şekilde kullanır.
     *
     * getUserById(@PathVariable("id") Long id): Kullanıcı ID'si verilen kullanıcının bilgilerini döndürür.
     *
     * getUsers(): Tüm kullanıcıların bilgilerini döndürür.
     *
     * createUser(@Valid @RequestBody UserCreateDTO userCreateDto): Verilen bilgilerle yeni bir kullanıcı oluşturur.
     *
     * updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO): Verilen ID'ye sahip kullanıcının bilgilerini günceller.
     *
     * deleteUser(@PathVariable("id") Long id): Verilen ID'ye sahip kullanıcıyı siler.
     *
     * slice(Pageable pageable): Kullanıcıların bir sayfasını döndürür.
     *
     * putAddress(@RequestParam Long address_id, Long user_id): Verilen adres_id ve user_id ile kullanıcının adresini günceller.
     *
     * getUsersWithAddress(): Adresi olan tüm kullanıcıların bilgilerini döndürür.
     */

    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable("id") Long id){
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
        public ResponseEntity<List<UserViewDTO>> getUsers(){
           final List<UserViewDTO> users=userService.getUsers();
            return ResponseEntity.ok(users);
        }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDto){
        userService.createUser(userCreateDto);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id,@RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO user=userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(new GenericResponse("User Updated."));
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }

    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
        final List<UserViewDTO> users= userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

    @PutMapping("v1/user/putAddress")
    public ResponseEntity<UserViewDTO> putAddress(@RequestParam Long address_id,Long user_id){
        final UserViewDTO user=userService.putAddress(address_id,user_id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/usersWithAddress")
    public ResponseEntity<List<UserViewDTO>> getUsersWithAddress(){
        final List<UserViewDTO> users= userService.getUsersWithAddress();
        return ResponseEntity.ok(users);
    }

}
