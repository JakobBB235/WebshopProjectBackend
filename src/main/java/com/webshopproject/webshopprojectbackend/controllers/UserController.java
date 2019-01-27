package com.webshopproject.webshopprojectbackend.controllers;

import com.webshopproject.webshopprojectbackend.models.User;
import com.webshopproject.webshopprojectbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){ //should return the new item with id?
        return userService.createNewUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){ //params correct?
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
