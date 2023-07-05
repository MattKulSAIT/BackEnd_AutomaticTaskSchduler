package com.AutoTask.AutoTask.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskNumber;
    private String title;
    private Date creationDate;
    private String description;
    private String name;
    private String email;
    private int phoneNumber;
    private int status;
    private double timeToComplete;
    private int category; //Kinda want to change this
    private int empId;
    //How will we know when the task is set to be completed?????????

    public Task(){

    }
    public Task(String title, String description,
                String fName, String lName, String email,
                int phoneNumber,int category) {
        this.title=title;
        this.description = description;
        this.name = fName + " " + lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.category = category;

        //Put the call to get the highest task number

        //set status to pending or 1
        this.status = 1;

        //Time to complete default values
        //DeskSide = 0.5
        //Database = 1.5
        //Networking = 1.0
        //mobile telephone support = 0.5
        if(category == 1) {
            this.timeToComplete = 0.5;
        }
        else if(category == 2) {
            this.timeToComplete = 1.5;
        }
        else if(category == 3) {
            this.timeToComplete = 1.0;
        }
        else {
            this.timeToComplete = 0.5;
        }


    }

    /**
     * Method to assign the Task to a specified employee
     * @param empId the id of the resorce
     */
    public void assignToEmployee(int empId) {
        this.empId = empId;
    }

    /**
     * @return the taskNumber
     */
    public int getTaskNumber() {
        return taskNumber;
    }

    /**
     * @param taskNumber the taskNumber to set
     */
    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the timeToComplete
     */
    public double getTimeToComplete() {
        return timeToComplete;
    }

    /**
     * @param timeToComplete the timeToComplete to set
     */
    public void setTimeToComplete(double timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    /**
     * @return the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * @return the empId
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }




}
