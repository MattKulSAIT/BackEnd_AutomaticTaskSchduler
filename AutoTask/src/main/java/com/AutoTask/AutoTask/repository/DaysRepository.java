package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.DayId;
import com.AutoTask.AutoTask.models.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface DaysRepository extends JpaRepository<Days, DayId>{
/*
    @Query("SELECT d FROM Days d WHERE d.id.employeeId = :employeeId AND d.hoursAvailable >= :minHoursAvailable AND d.id.date = (SELECT MIN(d2.id.date) FROM Days d2 WHERE d2.id.employeeid = :employeeId AND d2.hoursAvailable >= :minHoursAvailable)")
    Days findBestDay(int employeeId, double minHoursAvailable);

    @Query("SELECT d FROM Days d WHERE d.id.employeeId = :employeeId AND d.id.date = :date")
    Days findDay(DayId dayId);
*/

}
