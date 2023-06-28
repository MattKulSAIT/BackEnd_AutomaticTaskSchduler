package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService us;
    @PostMapping("")
    public ResponseEntity<String> login(@RequestParam("employeeId") int employeeId, @RequestParam("password") String password) throws Exception {
        User user = us.login(employeeId, password);
        if (user == null) {
            return ResponseEntity.ok("User Not Found");
        }
        return ResponseEntity.ok("Login Successful");
    }
}
