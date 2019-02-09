package com.webshopproject.webshopprojectbackend.dto;

import com.webshopproject.webshopprojectbackend.models.Item;
import com.webshopproject.webshopprojectbackend.models.User;

import java.util.List;

public class UserDto {

    private long userId;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean enabled;
    private List<Item> items;

    public User convertToUser(){ //is this needed?
        User theUser = new User();
        theUser.setUserId(this.getUserId());
        theUser.setUsername(this.getUsername());
        theUser.setPassword(this.getPassword());
        theUser.setEmail(this.getEmail());
        theUser.setRole(this.getRole());
        theUser.setEnabled(this.isEnabled());

        return theUser;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
