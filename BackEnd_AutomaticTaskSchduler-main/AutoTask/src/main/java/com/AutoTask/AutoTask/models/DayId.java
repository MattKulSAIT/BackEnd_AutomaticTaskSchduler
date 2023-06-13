package com.AutoTask.AutoTask.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
@Embeddable
public class DayId implements Serializable {
    private Date date;
    private int employeeID;

    public DayId(Date date, int employeeId) {
        this.date = date;
        this.employeeID = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }




}
