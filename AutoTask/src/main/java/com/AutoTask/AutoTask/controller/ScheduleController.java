package com.AutoTask.AutoTask.controller;

import com.AutoTask.AutoTask.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    /**
     * Autowire to let us access ScheduleService
     */
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/total/{empId}")
    public double getTotalHours(@PathVariable int empId){
        return scheduleService.getTotalHours(empId);
    }

    @GetMapping("/working/{empId}")
    public double getWorkingHours(@PathVariable int empId){
        return scheduleService.getWorkHours(empId);
    }

    @GetMapping("/available/{empId}")
    public double getAvailableHours(@PathVariable int empId){
        return scheduleService.getAvaibleHours(empId);
    }






}
