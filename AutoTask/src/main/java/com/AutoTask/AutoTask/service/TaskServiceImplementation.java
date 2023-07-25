package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.ArchivedTask;
import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.repository.ArchivedTaskRepository;
import com.AutoTask.AutoTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Class to handle any interactions with Task objects
 */
@Service
public class TaskServiceImplementation implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ArchivedTaskRepository archivedTaskRepository;

    /**
     * Method to save the task to the database
     * @param task the updated task to be saved
     * @return the fixed task object
     */
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

    /**
     * Method to get all the tasks for one Resource
     * @param empId the id of the employee
     * @return List containing all tasks assigned to them
     */
    @Override
    public List<Task> getAllTaskAssignedToResource(int empId) {
        return taskRepository.findTaskByEmployeeId(empId);
    }


    /**
     * The method for resources to update a tasks information
     * @param id the unique id for the task
     * @param status the current completion status of the task
     * @param type the category of the task
     * @param time the estimated time to complete
     */
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

    /**
     * Method for Admin to update a task
     * @param id the unique id given to every task
     * @param status the current completion status of the task
     * @param type the category of the task
     * @param time the estimated time to complete
     * @param empId the unique id given to every user
     */
    @Override
    public void adminUpdateTask(int id, int status, int type, double time, int empId) {
        Optional<Task> optionalTask = findByTaskNumber(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();

            task.setStatus(status);
            task.setCategory(type);
            task.setTimeToComplete(time);
            task.setEmpId(empId);

            saveTask(task);
        }
    }

    /**
     * Method to archive a task once its been marked as complete
     * @param id the unique id given to every task
     * @param status the completion status of the task
     * @param type the category of the task
     * @param time the estimated time to complete
     */
    @Override
    public void completeTask(int id, int status, int type, double time) {
        Optional<Task> optionalTask = findByTaskNumber(id);
        if(optionalTask.isPresent()){
            Task completedTask = optionalTask.get();

            ArchivedTask archivedTask = new ArchivedTask();
            archivedTask.setTaskNumber(completedTask.getTaskNumber());
            archivedTask.setCategory(completedTask.getCategory());
            archivedTask.setCompletionDate(new Date());
            archivedTask.setCreationDate(completedTask.getCreationDate());
            archivedTask.setDescription(completedTask.getDescription());
            archivedTask.setEmail(completedTask.getEmail());
            archivedTask.setEmpId(completedTask.getEmpId());
            archivedTask.setStatus(4);
            archivedTask.setTitle(completedTask.getTitle());

            archivedTaskRepository.save(archivedTask);

            taskRepository.delete(completedTask);
        }
    }


}
