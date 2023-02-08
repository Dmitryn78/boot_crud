package com.example.boot_crud.dao;


import com.example.boot_crud.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void addUser(User user);

    public User getUserById(int id);

    public void deleteUserById(int id);

    public void updateUserById(int id, User user);
}

