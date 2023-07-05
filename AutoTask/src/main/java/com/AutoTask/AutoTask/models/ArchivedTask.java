package com.AutoTask.AutoTask.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ArchivedTask {

    @Id
    private int taskNumber;
    private String title;
    private Date creationDate;
    private Date completionDate;
    private String description;
    private String email;
    private int status;
    private int category;
    private int empId;

    /**
     * Constructor to make a new Archived Task
     *
     * !!!!This is only in for testing purposes and should never be used!!!!!
     * @param taskNumber
     * @param title
     * @param creationDate
     * @param completionDate
     * @param description
     * @param email
     * @param category
     * @param empId
     */
    public ArchivedTask(int taskNumber, String title, Date creationDate, Date completionDate, String description, String email, int category, int empId) {
        this.taskNumber = taskNumber;
        this.title = title;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.description = description;
        this.email = email;
        this.status = 4;
        this.category = category;
        this.empId = empId;
    }

    /**
     * Constructor to take in a task and convert it to a ArchivedTask
     * @param completedTask this is the task that was just marked as complete
     */
    public ArchivedTask(Task completedTask){
        this.taskNumber = completedTask.getTaskNumber();
        this.title = completedTask.getTitle();
        this.creationDate = completedTask.getCreationDate();
        this.completionDate = new Date();
        this.description = completedTask.getDescription();
        this.email = completedTask.getEmail();
        this.status = 4;
        this.category = completedTask.getCategory();
        this.empId = completedTask.getEmpId();
    }


    public ArchivedTask(){

    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
