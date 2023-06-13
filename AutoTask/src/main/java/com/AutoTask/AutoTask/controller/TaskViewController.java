package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/taskView")
public class TaskViewController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "{taskNumber}")
    public Optional<Task> viewSelectedTask(@PathVariable int taskNumber){
        return taskService.findByTaskNumber(taskNumber);
    }

}
