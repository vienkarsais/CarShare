package com.edgars.CarShare.services;

import com.edgars.CarShare.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    List<User> showAllUsers();
    void deleteUser(Long id);
    void deleteAllUsers();
    User findUserById(Long id);
}
