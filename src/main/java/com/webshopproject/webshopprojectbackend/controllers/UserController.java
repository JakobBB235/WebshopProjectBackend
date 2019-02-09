package com.webshopproject.webshopprojectbackend.controllers;

import com.webshopproject.webshopprojectbackend.dto.UserDto;
import com.webshopproject.webshopprojectbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable Long id){
//        return userService.getUser(id);
//    }
//
//    @PostMapping("/user")
//    public User addUser(@RequestBody User user){ //should return the new item with id?
//        return userService.createNewUser(user);
//    }
//
//    @PutMapping("/user/{id}")
//    public void updateUser(@RequestBody User user, @PathVariable Long id){ //params correct?
//        userService.updateUser(user);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public void deleteUser(@PathVariable Long id){
//        userService.deleteUser(id);
//    }
//
//    //Login
//    @PostMapping("/user/login")
//    public User login(@RequestBody User user){
//        return userService.login(user);
//    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public UserDto addUser(@RequestBody UserDto user){ //should return the new item with id?
        return userService.createNewUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody UserDto user, @PathVariable Long id){ //params correct?
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    //Login
    @PostMapping("/user/login")
    public UserDto login(@RequestBody UserDto user){
        return userService.login(user);
    }
}
