package com.AutoTask.AutoTask.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class DayId implements Serializable {
    private Date date;
    @Column(name = "employeeid")
    private int employeeID;

    public DayId(Date  date, int employeeID) {
        this.date = date;
        this.employeeID = employeeID;
    }

    public DayId(){}

    public Date  getDate() {
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
