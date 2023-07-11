package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT s FROM User s WHERE s.employeeId = :employeeId")
    Optional<User> findUserByEmpId(int employeeId);

    @Query("SELECT s FROM User s WHERE s.role = 2")
    List<User> getAllResource();

    @Query("SELECT s FROM User s WHERE s.role = 1")
    List<User> getAllAdmin();

    @Query("SELECT COUNT(t.taskNumber) FROM Task t WHERE t.empId = :empId")
    int numOfTasks(int empId);
}
