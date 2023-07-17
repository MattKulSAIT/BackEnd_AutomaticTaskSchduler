package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.ArchivedTask;
import com.AutoTask.AutoTask.repository.ArchivedTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveTaskServiceImplementation implements ArchivedTaskService {
    @Autowired
    private ArchivedTaskRepository archivedTaskRepository;


    @Override
    public List<ArchivedTask> getAllArchivedTasks() {
        return archivedTaskRepository.findAll();
    }

    @Override
    public Optional<ArchivedTask> findByTaskNumber(int taskNumber) {
        return archivedTaskRepository.findArchivedTaskByTaskNumber(taskNumber);
    }
}
