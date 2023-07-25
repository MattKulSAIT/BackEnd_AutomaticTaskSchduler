package com.AutoTask.AutoTask.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private String email;
    private String password;
    private String phoneNum;
//    private Schedule schedule;

    @Column(name = "desk_skill")
    private int deskSkill;

    @Column(name = "data_skill")
    private int dataSkill;

    @Column(name = "net_skill")
    private int netSkill;

    @Column(name = "mobile_skill")
    private int mobileSkill;
    private int role;

    public User(){
    }

    public User(String name, String email, String password, String phoneNum) {
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.role = 1;
    }
    public User(String name, String email, String password, String phoneNum, int deskSkill, int dataSkill, int netSkill, int mobileSkill) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.deskSkill = deskSkill;
        this.dataSkill = dataSkill;
        this.netSkill = netSkill;
        this.mobileSkill = mobileSkill;
        this.role = 2;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
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

//    public Schedule getSchedule() {
//        return schedule;
//    }
//
//    public void setSchedule(Schedule schedule) {
//        this.schedule = schedule;
//    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDeskSkill() {
        return deskSkill;
    }

    public void setDeskSkill(int deskSkill) {
        this.deskSkill = deskSkill;
    }

    public int getDataSkill() {
        return dataSkill;
    }

    public void setDataSkill(int dataSkill) {
        this.dataSkill = dataSkill;
    }

    public int getNetSkill() {
        return netSkill;
    }

    public void setNetSkill(int netSkill) {
        this.netSkill = netSkill;
    }

    public int getMobileSkill() {
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
