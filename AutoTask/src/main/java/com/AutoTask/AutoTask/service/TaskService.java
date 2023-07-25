package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTasks();

    public Optional<Task> findByTaskNumber(int taskNumber);

    public List<Task> getAllTaskAssignedToResource(int empId);

    public void resourceUpdateTask(int id, int status, int type, double time);

    public void adminUpdateTask(int id, int status, int type, double time, int empId);

    public void completeTask(int id, int status, int type, double time);
}
