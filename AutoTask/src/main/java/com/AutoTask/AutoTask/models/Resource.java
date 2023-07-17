package com.AutoTask.AutoTask.models;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {
    private Task task;
    private String email;
    private String password;
    private int employeeID;
    private String phoneNum;
    private Schedule schedule;
    private int deskSkill;
    private int dataSkill;
    private int netSkill;
    private int mobileSkill;
    private int role;

    public Resource(int id, int deskSkill , int dataSkill, int netSkill, int mobileSkill,
                    String email, String phoneNum, String password, Schedule schedule) {
        this.employeeID = id;
        this.deskSkill = deskSkill;
        this.dataSkill = dataSkill;
        this.netSkill = netSkill;
        this.mobileSkill = mobileSkill;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.schedule = schedule;
        this.role = 2;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int hasDeskSkill() {
        return deskSkill;
    }

    public void setDeskSkill(int deskSkill) {
        this.deskSkill = deskSkill;
    }

    public int hasDataSkill() {
        return dataSkill;
    }

    public void setDataSkill(int dataSkill) {
        this.dataSkill = dataSkill;
    }

    public int hasNetSkill() {
        return netSkill;
    }

    public void setNetSkill(int netSkill) {
        this.netSkill = netSkill;
    }

    public int hasMobileSkill() {
        return mobileSkill;
    }

    public void setMobileSkill(int mobileSkill) {
        this.mobileSkill = mobileSkill;
    }

    public void editStatus(Task task) {
        //TODO
    }
    public void adjustHours(Date day, double hours) {
        //TODO
    }
}
    //Resource (Q)
    //Admin (Q)
    //Schedule (Q)
    //Days (Q)