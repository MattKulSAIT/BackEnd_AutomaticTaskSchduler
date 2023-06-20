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

    /**
     * Method to let you get a user by there ID
     * @param empId the Unique Id used to indentify them
     * @return an Optional<User> if the user is found
     */
    @Override
    public Optional<User> findById(int empId) {
        return userRepository.findUserByEmpId(empId);
    }

    /**
     * Method to log a user in
     * @param id the Unique Id using to identify users in the system
     * @param password the password linked with the ID
     * @return A user if the username and passwork match
     * @throws Exception
     */
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
