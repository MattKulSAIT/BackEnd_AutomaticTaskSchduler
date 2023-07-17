package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class to control the CreateNewUser page on the frontend
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newResource")
public class NewResourceController {

    /**
     * Autowire to let us access UserService
     */
    @Autowired
    UserService us;

    /**
     * method to take in a newResource object
     * @param newResource the User object to be added to our system
     * @return ResponceEntity if the Resource was created succesfully
     */
    @PostMapping("")
    public ResponseEntity<String> newResource(@RequestBody User newResource) {
        us.saveUser(newResource);
        return ResponseEntity.ok("Resource created successfully");
    }
}