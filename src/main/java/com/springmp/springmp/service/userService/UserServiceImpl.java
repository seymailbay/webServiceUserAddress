package com.springmp.springmp.service.userService;

import com.springmp.springmp.dto.userDTO.UserCreateDTO;
import com.springmp.springmp.dto.userDTO.UserUpdateDTO;
import com.springmp.springmp.dto.userDTO.UserViewDTO;
import com.springmp.springmp.exception.NotFoundException;
import com.springmp.springmp.model.Address;
import com.springmp.springmp.model.User;
import com.springmp.springmp.repository.addressRepository.AddressRepository;
import com.springmp.springmp.repository.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserServiceImpl CRUD işlemleri gerçekleştirir.
 *
 * getUserById(Long id) metodu: Verilen id'ye sahip kullanıcıyı veritabanından getirir ve bunu UserViewDTO tipinde döndürür.
 * getUsers() metodu: Tüm kullanıcıları veritabanından getirir ve bunları UserViewDTO tipinde bir liste olarak döndürür.
 * createUser(UserCreateDTO userCreateDto) metodu: Veritabanına yeni bir kullanıcı ekler ve eklenen kullanıcını UserViewDTO tipinde döndürür.
 * updateUser(Long id, UserUpdateDTO userUpdateDTO) metodu: Verilen id'ye sahip kullanıcının bilgilerini günceller ve güncellenen kullanıcıyı UserViewDTO tipinde döndürür.
 * deleteUser(Long id) metodu: Verilen id'ye sahip kullanıcıyı veritabanından siler.
 * slice(Pageable pageable) metodu: Kullanıcıları veritabanından belirli bir sayfa olarak getirir ve bunları UserViewDTO tipinde bir liste olarak döndürür.
 * putAddress(Long address_id, Long user_id) metodu: Verilen adres id'sine sahip adresi, verilen kullanıcı id'sine sahip kullanıcıya ekler ve güncellenen kullanıcıyı UserViewDTO tipinde döndürür.
 * getUsersWithAddress() metodu: Tüm kullanıcıları veritabanından getirir ve bunların adresleri ile birlikte UserViewDTO tipinde bir liste olarak döndürür.
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
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

    @Override
    @Transactional
    public UserViewDTO putAddress(Long address_id, Long user_id) {
        final Address address =addressRepository.findById(address_id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        final User user =userRepository.findById(user_id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        user.setAddress(address);
        final User updatedUser=userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO>  getUsersWithAddress() {
        return userRepository.findAll().stream().map(UserViewDTO::ofWithAddress).collect(Collectors.toList());
    }
}
