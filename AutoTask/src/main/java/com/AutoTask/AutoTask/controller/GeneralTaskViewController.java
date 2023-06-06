package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generalTask")
public class GeneralTaskViewController {
    @Autowired
    private TaskService taskService;


    @GetMapping("")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
