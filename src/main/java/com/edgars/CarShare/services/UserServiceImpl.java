package com.edgars.CarShare.services;

import com.edgars.CarShare.exceptions.UserNotFoundException;
import com.edgars.CarShare.models.User;
import com.edgars.CarShare.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public User addUser(User user){


        final String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return userRepository.save(user);
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }

    public List<User> showAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id: " + id + " not found"));
    }
}
