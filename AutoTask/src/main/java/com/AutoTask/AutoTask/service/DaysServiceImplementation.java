package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Days;
import com.AutoTask.AutoTask.repository.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DaysServiceImplementation implements DaysService{
    @Autowired
    private DaysRepository daysRepository;

    @Override
    public Days saveDays(Days days) {
        return daysRepository.save(days);
    }

    @Override
    public List<Days> getAllDays() {
        return daysRepository.findAll();
    }
}
