package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/resourceEdit")
public class EditResourceController {

    @Autowired
    UserService us;

    @GetMapping(path = "{id}")
    public Optional<User> viewResource(@PathVariable int id) {
        return us.findById(id);
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<String> editResource(@PathVariable int id, @RequestBody User editedResource) {
        us.updateUser(id, editedResource);
        return ResponseEntity.ok("Resourced edited successfully");
    }

}
