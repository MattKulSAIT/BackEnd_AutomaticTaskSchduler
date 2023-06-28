package com.AutoTask.AutoTask.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;


@Entity
public class Days implements Serializable{
    @EmbeddedId
    private DayId id;
    private double hoursAvailable;

    public Days(DayId id, double hours) {
        this.hoursAvailable = hours;
        this.id = id;
    }

    public double getHoursAvailable() {
        return hoursAvailable;
    }

    public void setHoursAvailable(double hours) {
        this.hoursAvailable = hours;
    }

}
