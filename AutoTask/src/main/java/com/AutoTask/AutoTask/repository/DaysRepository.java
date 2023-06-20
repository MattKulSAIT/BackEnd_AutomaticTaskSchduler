package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.DayId;
import com.AutoTask.AutoTask.models.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface DaysRepository extends JpaRepository<Days, DayId>{
}
