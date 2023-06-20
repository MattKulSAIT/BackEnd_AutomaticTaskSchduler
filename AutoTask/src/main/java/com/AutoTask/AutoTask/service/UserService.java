package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User login(int id, String password) throws Exception;
}
