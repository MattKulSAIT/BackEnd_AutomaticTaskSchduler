package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.ArchivedTask;
import com.AutoTask.AutoTask.service.ArchivedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/generalArchivedTask")
public class GeneralArchivedTaskViewController {
    @Autowired
    private ArchivedTaskService archivedTaskService;

    @GetMapping("")
    public List<ArchivedTask> getAllArchivedTasks(){
        return archivedTaskService.getAllArchivedTasks();
    }
}
