package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplementation implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findByTaskNumber(int taskNumber) {
        return taskRepository.findTaskByTaskNumber(taskNumber);
    }
}
