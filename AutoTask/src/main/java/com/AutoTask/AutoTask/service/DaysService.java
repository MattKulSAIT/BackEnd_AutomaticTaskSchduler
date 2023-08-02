package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Days;

import java.sql.Date;
import java.util.List;

public interface DaysService {
    public Days saveDays(Days days);
    public List<Days> getAllDays();
}
