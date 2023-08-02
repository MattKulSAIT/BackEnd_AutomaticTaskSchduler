package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Days;
import com.AutoTask.AutoTask.models.Task;

import java.sql.Date;

public interface ScheduleService {

    public void assignTask(Task task);

    public void changeHours(Days theDay, double hours);

    public void reAssignTask(Task task, int empId);

    public void adminReAssign(Task task, int empId);

    public double getAvaibleHours(int empId);

    public double getTotalHours(int empId);

    public double getWorkHours(int empId);

    public void populateWeek(Date date, int empId, int hoursAvaible, int setHours);
}
