package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();

    List<User> getAllResource();

    List<User> getAllAdmin();

    public Optional<User>findById(int empId);
    public User login(int id, String password) throws Exception;

    public int numOfTasks(int empId);
}
