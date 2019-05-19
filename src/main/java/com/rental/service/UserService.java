package com.rental.service;

import java.util.List;

import com.rental.entity.User;

public interface UserService {

    List<User> getAllUsers(String username, String name, Integer role, Integer status);
    User getUserById(Integer userId);
    User getUserByUsername(String username);
    boolean updateUser(User user);
    boolean createUser(User user);
    boolean deactivateUser(Integer userId);
    String showErrorMessage();
}
