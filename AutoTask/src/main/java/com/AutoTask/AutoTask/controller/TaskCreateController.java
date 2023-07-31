package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.service.ScheduleService;
import com.AutoTask.AutoTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class to control the createTask page
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newTask")
public class TaskCreateController {

    /**
     * Autowire to connect to the service layer
     */
    @Autowired
    private TaskService taskService;

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("")
    public void createTask(@RequestBody Task newTask){
        taskService.saveTask(newTask);
        scheduleService.assignTask(newTask);
    }
}
