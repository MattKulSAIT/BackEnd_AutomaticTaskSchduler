package com.AutoTask.AutoTask.models;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    private Task task;
    private int employeeID;
    private String email;
    private String password;
    private String phoneNum;
    private int role;

    public Admin(int id, String email, String password, String phoneNum) {
        super(id, email, password, phoneNum);
        this.role = 1;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void assignTask(Task task, String empNum) {
        //TODO
    }

    public int selectEmployee(Resource emp) {
        //TODO
        return 0;
    }

    public Resource newResource(int id, boolean deskSkill, boolean dataSkill, boolean netSkill,
                                boolean mobileSkill, String email, String phoneNum, String password, Schedule schedule, int role) {
        Resource res = new Resource(id, deskSkill, dataSkill, netSkill, mobileSkill, email, phoneNum, password, schedule);
        return res;
    }
}