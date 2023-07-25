package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.TaskService;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/resourceView")
public class ResourceViewController {

    /**
     * AutoWire to gain access to the userService method
     */
    @Autowired
    private UserService userService;

    /**
     * AutoWire to gain access to the taskService methods
     */
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "{empId}")
    public Optional<User> viewSelectedResource(@PathVariable int empId){
        return userService.findById(empId);
    }

    @GetMapping(path = "tasks/{empId}")
    public List<Task> getResourcesTasks(@PathVariable int empId){return taskService.getAllTaskAssignedToResource(empId);}
}
