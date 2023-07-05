package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/taskEdit")
public class TaskEditController {

    @Autowired
    private TaskService taskService;


    @GetMapping(path = "{taskNumber}")
    public Optional<Task> viewSelectedTask(@PathVariable int taskNumber){
        return taskService.findByTaskNumber(taskNumber);
    }

    @PatchMapping(path = "{taskNumber}")
    public void updateTask(@PathVariable int taskNumber,
                           @RequestParam("status") int status,
                           @RequestParam("type")int type,
                           @RequestParam("time")double time){
        taskService.resourceUpdateTask(taskNumber,status,type,time);
    }
}
