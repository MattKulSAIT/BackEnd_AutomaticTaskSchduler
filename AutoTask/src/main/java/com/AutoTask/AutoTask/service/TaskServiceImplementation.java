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

    /**
     * Method to provide a list of all tasks
     * @return A list object the contains all the objects in
     */
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Method to find task by the unique Task Id
     * @param taskNumber
     * @return the Task if found
     */
    @Override
    public Optional<Task> findByTaskNumber(int taskNumber) {
        return taskRepository.findTaskByTaskNumber(taskNumber);
    }


    @Override
    public void resourceUpdateTask(int id, int status, int type, double time) {
        Optional<Task> optionalTask = findByTaskNumber(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();

            task.setStatus(status);
            task.setCategory(type);
            task.setTimeToComplete(time);

            saveTask(task);
        }

    }


}
