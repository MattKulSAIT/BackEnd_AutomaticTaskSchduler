package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTasks();
}
