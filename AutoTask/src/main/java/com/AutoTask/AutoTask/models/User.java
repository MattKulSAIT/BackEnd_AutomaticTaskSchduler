package com.AutoTask.AutoTask.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class User implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String email;
    private String password;
    private String phoneNum;
    private String name;
    //private Schedule schedule;
    private int deskSkill;
    private int dataSkill;
    private int netSkill;
    private int mobileSkill;
    private int role;

    public User(){
    }
    public User(int employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }

    public User(int employeeId, String email, String password, String phoneNum, String name) {
        this.employeeId = employeeId;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.role = 1;
        this.name=name;
    }
    public User(int id, String email, String password, String phoneNum, String name, int deskSkill, int dataSkill, int netSkill, int mobileSkill) {
        this.employeeId = id;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.name = name;
        this.deskSkill = deskSkill;
        this.dataSkill = dataSkill;
        this.netSkill = netSkill;
        this.mobileSkill = mobileSkill;
        this.role = 2;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getName(){ return this.name; }

    public void setName(String name){this.name = name; }


//    public Schedule getSchedule() {
//        return schedule;
//    }

//    public void setSchedule(Schedule schedule) {
//        this.schedule = schedule;
//    }

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
