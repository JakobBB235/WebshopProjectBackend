package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.dto.UserDto;
import com.webshopproject.webshopprojectbackend.models.User;

public interface UserService {
//    User getUser(long id);
//    User createNewUser(User user);
//    void updateUser(User user);
//    void deleteUser(long id);
//    void disableUser(long id);
//    void enableUser(long id);
//
//    User login(User user);

    UserDto getUser(long id);
    UserDto createNewUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void deleteUser(long id);
    void disableUser(long id);
    void enableUser(long id);

    UserDto login(UserDto userDto);
}
