package com.springmp.springmp.repository;

import com.springmp.springmp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//The UserRepository interface extends the JpaRepository interface,
// which provides a set of methods for interacting with a database through JPA (Java Persistence API).
// These methods include basic CRUD (Create, Read, Update, Delete) operations as well as pagination and sorting.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByUserName(String userName);

}
