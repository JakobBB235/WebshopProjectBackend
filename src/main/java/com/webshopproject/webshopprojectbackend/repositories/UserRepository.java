package com.webshopproject.webshopprojectbackend.repositories;

import com.webshopproject.webshopprojectbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
