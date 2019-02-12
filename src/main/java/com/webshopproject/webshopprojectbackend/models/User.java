package com.webshopproject.webshopprojectbackend.models;

import com.webshopproject.webshopprojectbackend.dto.UserDto;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean enabled;
    //address
    //phoneNumber
    //

    //Relations
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Item> items;

    public UserDto convertToDto(){
        UserDto userToView = new UserDto();
        userToView.setUserId(this.getUserId());
        userToView.setUsername(this.getUsername());
//        userToView.setPassword(this.getPassword());
        userToView.setEmail(this.getEmail());
        userToView.setRole(this.getRole());
        userToView.setEnabled(this.isEnabled());
//        userToView.setItems(this.getItems()); //Convert items to DTO instead.
        userToView.setItems(this.getItems().stream().map(Item::convertToDto).collect(toList()));

        return userToView;
    }

    //Getters and setters
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
