package com.rental.dao;

import java.util.List;

import com.rental.entity.User;

public interface UserDao {

    List<User> getAllUsers(String username, String name, Integer role, Integer status);
    User getUserById(Integer userId);
    User getUserByUsername(String username);
    void updateUser(User user);
    void createUser(User user);
    void deactivateUser(Integer userId);
}
