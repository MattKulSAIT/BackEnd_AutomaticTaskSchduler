package com.AutoTask.AutoTask.controller;


import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/generalResource")
public class GeneralResourceViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/R")
    public List<User> getAllResource(){
        return userService.getAllResource();
    }

    @GetMapping("/A")
    public List<User> getAllAdmin(){
        return userService.getAllAdmin();
    }
}
