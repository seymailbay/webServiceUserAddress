package com.springmp.springmp.api;

import com.springmp.springmp.dto.UserCreateDTO;
import com.springmp.springmp.dto.UserUpdateDTO;
import com.springmp.springmp.dto.UserViewDTO;
import com.springmp.springmp.service.UserService;
import com.springmp.springmp.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Gelen isteklerin yakalanmasını sağlar
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

     //In the getUserById method, the ResponseEntity class is used to wrap the UserViewDTO object in an HTTP response and return it to the client.
    // The ResponseEntity.ok method creates an HTTP 200 OK response,
    // which indicates that the request was successful and that the requested data is included in the response body.

    private final UserService userService;
    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable("id") Long id){ //The @PathVariable annotation tells the framework to bind the value of the id path variable in the URL to the id parameter in the method.
        final UserViewDTO user = userService.getUserById(id); // final(immutable object) ensure that the DTO remains a simple, immutable data container that can be safely shared between different parts of the application.
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
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id,@RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO user=userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
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

}
