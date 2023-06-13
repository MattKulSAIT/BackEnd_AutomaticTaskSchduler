package com.AutoTask.AutoTask.models;


import java.util.ArrayList;
import java.util.Date;

public class Schedule {

    private ArrayList<Days> employeeSchedule;
    private int employeeID;

    public Schedule(ArrayList<Days> empSchedule, int id) {
        this.employeeSchedule = empSchedule;
        this.employeeID = id;
    }

    public ArrayList<Days> getEmployeeSchedule() {
        return employeeSchedule;
    }

    public void setEmployeeSchedule(ArrayList<Days> employeeSchedule) {
        this.employeeSchedule = employeeSchedule;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void bookDayOff(Date dayOff) {
        //TODO
    }

    public void adjustHours(Date day, double hours) {
        //TODO
    }
}
