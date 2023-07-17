package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.ArchivedTask;

import java.util.List;
import java.util.Optional;

public interface ArchivedTaskService {

    public List<ArchivedTask> getAllArchivedTasks();

    public Optional<ArchivedTask> findByTaskNumber(int taskNumber);
}
