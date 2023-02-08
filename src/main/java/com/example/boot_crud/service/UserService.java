package com.example.boot_crud.service;


import com.example.boot_crud.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUserById(int id);

    void updateUserById(int id, User user);

    User getUserById(int id);

    List<User> getAllUsers();
}