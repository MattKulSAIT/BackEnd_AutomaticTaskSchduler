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
    private double setHours;

    public Days(DayId id, double hours, double setHours) {
        this.hoursAvailable = hours;
        this.id = id;
        this.setHours = setHours;
    }

    public Days(){}

    public double getHoursAvailable() {
        return hoursAvailable;
    }

    public void setHoursAvailable(double hours) {
        this.hoursAvailable = hours;
    }

    public double getSetHours() {
        return setHours;
    }

    public void setSetHours(double setHours) {
        this.setHours = setHours;
    }

    public DayId getId() {return id;}
}
