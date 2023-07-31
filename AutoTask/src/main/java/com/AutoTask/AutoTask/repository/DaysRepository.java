package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.DayId;
import com.AutoTask.AutoTask.models.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DaysRepository extends JpaRepository<Days, DayId>{

    @Query("SELECT d FROM Days d WHERE d.id.employeeID = :employeeID AND d.hoursAvailable >= :minHoursAvailable AND d.id.date = (SELECT MIN(d2.id.date) FROM Days d2 WHERE d2.id.employeeID = :employeeID AND d2.hoursAvailable >= :minHoursAvailable)")
    Days findBestDay(int employeeID, double minHoursAvailable);

    @Query("SELECT d FROM Days d WHERE d.id.employeeID = :employeeID AND d.id.date = :date")
    Days findDay(int employeeID, Date date);

    @Query("SELECT d FROM Days d WHERE d.id.employeeID = :employeeID")
    List<Days> getAllDays(int employeeID);
}
