package com.springmp.springmp.service;

import com.springmp.springmp.dto.UserCreateDTO;
import com.springmp.springmp.dto.UserUpdateDTO;
import com.springmp.springmp.dto.UserViewDTO;
import com.springmp.springmp.exception.NotFoundException;
import com.springmp.springmp.model.User;
import com.springmp.springmp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)  //A transaction is a unit of work that is performed within a database
    public UserViewDTO getUserById(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDto) {
        final User user=userRepository.save(new User(userCreateDto.getUserName(),userCreateDto.getFirstName(),userCreateDto.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user=userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        final User updatedUser=userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        final User user=userRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        userRepository.deleteById(user.getId());

    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }
}
