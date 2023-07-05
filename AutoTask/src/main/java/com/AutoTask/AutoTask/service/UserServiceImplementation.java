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
     * Returned a list of all users with role id 2
     * @return
     */
    @Override
    public List<User> getAllResource(){return this.userRepository.getAllResource();}

    /**
     * Returns a list of all the Users with role id 1
     * @return
     */
    @Override
    public List<User> getAllAdmin(){return this.userRepository.getAllAdmin();}

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

    /**
     * Method to get the Number of Tasks for an employee for the
     * ResourceGeneralView
     * @param empId the unquie ID used to indetify everyone in the system
     * @return An int counting the number of tasks
     */
    @Override
    public int numOfTasks(int empId) {
        return userRepository.numOfTasks(empId);
    }

    @Override
    public void updateUser(int empId, User editUser) {
        Optional<User> optionalUser = findById(empId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setName(editUser.getName());
            user.setEmail(editUser.getEmail());
            user.setPassword(editUser.getPassword());
            user.setPhoneNum(editUser.getPhoneNum());
            user.setDeskSkill(editUser.hasDeskSkill());
            user.setDataSkill(editUser.hasDataSkill());
            user.setNetSkill(editUser.hasNetSkill());
            user.setMobileSkill(editUser.hasMobileSkill());

            saveUser(user);
        }
    }

}
