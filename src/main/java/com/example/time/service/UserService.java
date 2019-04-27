package com.example.time.service;

import com.example.time.pojo.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    void deleteUserById(long id);
    void updateUserById(User user);
    User findUserById(long id);
    List<User> findUserByUsername(String username);
    List<User> findUserByUsernameAndPassword(String username,String password);
    List<User> findAllUser();
}
