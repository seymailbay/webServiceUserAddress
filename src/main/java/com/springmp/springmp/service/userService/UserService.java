package com.springmp.springmp.service.userService;

import com.springmp.springmp.dto.userDTO.UserCreateDTO;
import com.springmp.springmp.dto.userDTO.UserUpdateDTO;
import com.springmp.springmp.dto.userDTO.UserViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * UserService CRUD operasyonlarının yapıldığı bir interface olarak arabirim görevi görerek çalışır.
 * Kullanıcınıyı kaydededen,güncelleyen,getiren soyut metotlara sahiptir.
 * Bu metotlar UserServiceImpl classında içeriğini doldurulur ve davranış verilir.
 */

public interface UserService {

    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUsers();

    List<UserViewDTO> getUsersWithAddress();

    UserViewDTO createUser(UserCreateDTO userCreateDto);

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);

    List<UserViewDTO> slice(Pageable pageable);

    UserViewDTO putAddress(Long address_id, Long user_id);
}