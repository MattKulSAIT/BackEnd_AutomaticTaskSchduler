package com.AutoTask.AutoTask.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;


@Entity
public class Days implements Serializable{
    @EmbeddedId
    private DayId id;

    @Column(name = "hours_available")
    private double hoursAvailable;
    //@Column(name = "date")
    //private java.sql.Date date; //I might have to set this equal to the ID date

    public Days(DayId id, double hours) {
        this.hoursAvailable = hours;
        this.id = id;
    }

    public Days(){}

    public double getHoursAvailable() {
        return hoursAvailable;
    }

    public void setHoursAvailable(double hours) {
        this.hoursAvailable = hours;
    }

}
