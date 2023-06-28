package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User login(int id, String password) throws Exception{
        Optional<User> loginUser = this.userRepository.findUserByEmpId(id);
        User user = loginUser.orElseThrow(() -> new RuntimeException("User not found"));
        if(password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
