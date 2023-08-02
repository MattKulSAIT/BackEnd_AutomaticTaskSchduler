package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.ScheduleService;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

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

    @Autowired
    ScheduleService su;

    /**
     * method to take in a newResource object
     * @param newResource the User object to be added to our system
     * @return ResponceEntity if the Resource was created succesfully
     */
    @PostMapping("")
    public ResponseEntity<String> newResource(@RequestBody User newResource) {
        us.saveUser(newResource);
        //populating first week logic
        if(newResource.getRole() == 2) {
            LocalDate today = LocalDate.now();
            Date date = Date.valueOf(today);
            su.populateWeek(date, newResource.getEmployeeId(), 8, 8);
        }
        return ResponseEntity.ok("Resource created successfully");
    }
}