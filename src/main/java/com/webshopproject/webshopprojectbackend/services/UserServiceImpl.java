package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.dto.UserDto;
import com.webshopproject.webshopprojectbackend.models.User;
import com.webshopproject.webshopprojectbackend.repositories.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public User getUser(long id) {
//        return userRepository.findById(id).orElse(null);
//    }

//    @Override
//    public User createNewUser(User user) {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        user.setEnabled(true);
//        user.setRole("USER");
//        return userRepository.save(user);
//    }

//    @Override
//    public User createNewUser(User user) {
//        user.setEnabled(true);
//        user.setRole("USER");
//        return userRepository.save(user);
//    }

//    @Override
//    public void updateUser(User user) {
////        boolean encrypt = false;
////        if (updatedUser.getEmail() != null)
////            theUser.setEmail(updatedUser.getEmail());
////        if (updatedUser.getPassword() != null) {
////            theUser.setPassword(updatedUser.getPassword());
////            encrypt = true;
////        }
////
////        if (encrypt)
////            theUser.setPassword(new BCryptPasswordEncoder().encode(theUser.getPassword()));
////
////        userRepository.save(theUser);
//    }

//    @Override
//    public void deleteUser(long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public void disableUser(long id) {
//        User theUser = userRepository.findById(id).orElse(null);
//        try {
//            theUser.setEnabled(false);
//            userRepository.save(theUser);
//        }
//        catch (NullPointerException e){
//            System.out.println("Error! User does not exist");
//        }
//    }
//
//    @Override
//    public void enableUser(long id) {
//        User theUser = userRepository.findById(id).orElse(null);
//        try {
//            theUser.setEnabled(true);
//            userRepository.save(theUser);
//        }
//        catch (NullPointerException e){
//            System.out.println("Error! User does not exist");
//        }
//    }
//
//    @Override
//    public User login(User user) {
//        //Try to get user with username and password
//        User foundUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//        System.out.println(foundUser.getUsername());
//        System.out.println(foundUser.getPassword());
//        return foundUser;
//    }


    @Override
    public UserDto getUser(long id) {
        User user = userRepository.findById(id).orElse(null);
        return user.convertToDto();
    }

    @Override
    public UserDto createNewUser(UserDto userDto) {
        User user = userDto.convertToUser();
        return userRepository.save(user).convertToDto();
    }

    @Override
    public void updateUser(UserDto userDto) {
        //Make sure that correct item list is set
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void disableUser(long id) {
        User theUser = userRepository.findById(id).orElse(null);
        try {
            theUser.setEnabled(false);
            userRepository.save(theUser);
        }
        catch (NullPointerException e){
            System.out.println("Error! User does not exist");
        }
    }

    @Override
    public void enableUser(long id) {
        User theUser = userRepository.findById(id).orElse(null);
        try {
            theUser.setEnabled(true);
            userRepository.save(theUser);
        }
        catch (NullPointerException e){
            System.out.println("Error! User does not exist");
        }
    }

    @Override
    public UserDto login(UserDto userDto) {
        //Try to get user with username and password
        User foundUser = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        return foundUser.convertToDto();
    }
}
