package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.ArchivedTask;
import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.service.ArchivedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/archiveTask")
public class ArchiveTaskViewController {

    @Autowired
    private ArchivedTaskService archivedTaskService;

    @GetMapping(path = "{taskNumber}")
    public Optional<ArchivedTask> viewSelectedArchivedTask(@PathVariable int taskNumber){
        return archivedTaskService.findByTaskNumber(taskNumber);
    }
}
