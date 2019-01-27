package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.models.User;
import com.webshopproject.webshopprojectbackend.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public User createNewUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }
}
