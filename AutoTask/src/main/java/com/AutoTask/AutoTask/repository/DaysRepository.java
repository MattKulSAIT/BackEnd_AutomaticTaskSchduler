package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.DayId;
import com.AutoTask.AutoTask.models.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * Method to add 1 day when creating a resource
     * Will have to call 5 times during resource creation
     * @param date The day assigned to this object
     * @param employeeID the unique identifer of the employee
     * @param hoursAvailable variable to keep track of days assigned hours
     * @param setHours how many hours they are supposed to work in a given day
     */
    @Query("INSERT INTO Days (id.date, id.employeeID, hoursAvailable, setHours) " +
            "VALUES (:date, :employeeID, :hoursAvailable, :setHours)")
    void saveDays(@Param("date") java.sql.Date date,
                  @Param("employeeID") int employeeID,
                  @Param("hoursAvailable") int hoursAvailable,
                  @Param("setHours") int setHours);

}
