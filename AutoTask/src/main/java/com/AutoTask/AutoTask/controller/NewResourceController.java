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
    public ResponseEntity<String> newResource(@RequestParam("fName") String fName,
                                              @RequestParam("lName") String lName,
                                              @RequestParam("email") String email,
                                              @RequestParam("password") String password,
                                              @RequestParam("phoneNum") String phoneNum,
                                              @RequestParam("desk") int deskSkill,
                                              @RequestParam("data") int dataSkill,
                                              @RequestParam("net") int netSkill,
                                              @RequestParam("mobile") int mobileSkill) {
        String name = fName + " " + lName;
        User user = new User(name, email, password, phoneNum, deskSkill, dataSkill, netSkill, mobileSkill);
        us.saveUser(user);
        return ResponseEntity.ok("Resource created successfully");
    }
}
