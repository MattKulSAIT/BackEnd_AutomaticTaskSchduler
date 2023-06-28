package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newResource")
public class NewResourceController {

    @Autowired
    UserService us;
    @PostMapping("")
    public ResponseEntity<String> newResource(@RequestBody User newResource) {
        us.saveUser(newResource);
        return ResponseEntity.ok("Resource created successfully");
    }
}
