package com.springmp.springmp.service;

import com.springmp.springmp.dto.UserCreateDTO;
import com.springmp.springmp.dto.UserUpdateDTO;
import com.springmp.springmp.dto.UserViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUsers();


    UserViewDTO createUser(UserCreateDTO userCreateDto);

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);

    List<UserViewDTO> slice(Pageable pageable);
}