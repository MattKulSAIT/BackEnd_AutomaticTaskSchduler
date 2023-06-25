package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/resourceView")
public class ResourceViewController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "{empId}")
    public Optional<User> viewSelectedResource(@PathVariable int empId){
        return userService.findById(empId);
    }
}
