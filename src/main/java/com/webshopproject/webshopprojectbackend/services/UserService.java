package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.models.User;

public interface UserService {
    User getUser(long id);
    User createNewUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    void disableUser(long id);
    void enableUser(long id);

    User login(User user);
}
