package com.springmp.springmp;

import com.springmp.springmp.dto.UserCreateDTO;
import com.springmp.springmp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)  // girişte doğrulama istememesi için
public class SpringMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMpApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUsers(UserService userService){
        return (args) ->{
            UserCreateDTO user = new UserCreateDTO();
            user.setUserName("seyma7");
            user.setFirstName("Seyma");
            user.setLastName("Ilbay");

            userService.createUser(user);

            UserCreateDTO user2 = new UserCreateDTO();
            user.setUserName("baris8");
            user.setFirstName("Baris");
            user.setLastName("Orhan");

            userService.createUser(user);

            UserCreateDTO user3 = new UserCreateDTO();
            user.setUserName("Melisa5");
            user.setFirstName("Melisa");
            user.setLastName("Ilbay");

            userService.createUser(user);
        };
    }

}
