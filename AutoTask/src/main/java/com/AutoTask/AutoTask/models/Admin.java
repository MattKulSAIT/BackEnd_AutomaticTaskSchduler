package com.AutoTask.AutoTask.models;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    private Task task;
    private int employeeID;
    private String email;
    private String password;
    private String phoneNum;
    private int role;

    public Admin(String name, String email, String password, String phoneNum) {
        super(name, email, password, phoneNum);

        this.role = 1;
    }

    public int getEmployeeID() {
        return employeeID;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

}