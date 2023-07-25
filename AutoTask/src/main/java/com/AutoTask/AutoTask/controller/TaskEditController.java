package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.service.TaskService;
import com.AutoTask.AutoTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class to control the TaskEdit pages on frontend
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/taskEdit")
public class TaskEditController {

    /**
     * Autowire to get access to TaskService class
     */
    @Autowired
    private TaskService taskService;

    /**
     * Autowire to get access to UserService class
     */
    @Autowired
    private UserService userService;

    /**
     * Method to get a specific task that was selected by the user
     * @param taskNumber the unique id for the task
     * @return Optional<Task> if the task is found
     */
    @GetMapping(path = "{taskNumber}")
    public Optional<Task> viewSelectedTask(@PathVariable int taskNumber){
        return taskService.findByTaskNumber(taskNumber);
    }

    /**
     * Method to get a list of all the users capable of doing a specific task
     * @param categoryId The id of the category
     * @return list of all the users that can do that task
     */
    @GetMapping(path = "/getCapableResource/{categoryId}")
    public List<User> allCapableResources(@PathVariable int categoryId){
        return userService.getCapableResources(categoryId);
    }

    //Need to add logic to archive the task if its marked as complete
    /**
     * Method to update a task from the Resources POV
     * @param taskNumber task number to update
     * @param status The status of the task
     * @param type What category the task belongs too
     * @param time The estimated time to complete the task
     */
    @PatchMapping(path = "{taskNumber}")
    public void updateTask(@PathVariable int taskNumber,
                           @RequestParam("status") int status,
                           @RequestParam("type")int type,
                           @RequestParam("time")double time){

        if(status==4){
            taskService.completeTask(taskNumber,status,type,time);
        }
        else {
            taskService.resourceUpdateTask(taskNumber, status, type, time);
        }
    }

    @PatchMapping(path = "/admin/{taskNumber}")
    public void updateTaskAdmin(@PathVariable int taskNumber,
                                @RequestParam("status") int status,
                                @RequestParam("type")int type,
                                @RequestParam("time")double time,
                                @RequestParam("empId") int empId){
        if(status==4){
            taskService.completeTask(taskNumber,status,type,time);
        }
        else {
            taskService.adminUpdateTask(taskNumber, status, type, time, empId);
        }
    }
}
