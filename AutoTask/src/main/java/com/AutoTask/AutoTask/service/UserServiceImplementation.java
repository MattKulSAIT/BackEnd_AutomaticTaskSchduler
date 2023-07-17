package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class to handle interactions with a User object
 */
@Service
public class UserServiceImplementation implements UserService{

    /**
     * Autowire to connect the UserRepository class
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to save a new User object to the database
     * @param user the new user object to be added
     * @return the succesfully created user
     */
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

    /**
     * Method to get all the resources capable of doing a specific task
     * @param categoryId the id used to check if the Resource can do a task
     * @return a list of all the resources capable of doing the task
     */
    @Override
    public List<User> getCapableResources(int categoryId) {
        switch (categoryId) {
            case 1:
                return userRepository.findDeskSideCapableResource();
            case 2:
                return userRepository.findDatabaseCapableResource();
            case 3:
                return userRepository.findNetworkCapableResource();
            case 4:
                return userRepository.findMobileCapableResource();
            default:
                return null;
        }
    }

    /**
     * Method used in the edit resource page of the system
     * @param empId the unique Id used to idetify people in our system
     * @param editUser The new user object holding the values that need to be updated
     */
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
