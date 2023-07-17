package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT s FROM User s WHERE s.employeeId = ?1")
    Optional<User> findUserByEmpId(int employeeId);

    @Query("SELECT s FROM User s WHERE s.role = 2")
    List<User> getAllResource();

    @Query("SELECT s FROM User s WHERE s.role = 1")
    List<User> getAllAdmin();

    @Query("SELECT COUNT(t.taskNumber) FROM Task t WHERE t.empId = :empId")
    int numOfTasks(int empId);

    @Query("SELECT u FROM User u WHERE u.deskSkill = 1 AND u.role = 2")
    List<User> findDeskSideCapableResource();

    @Query("SELECT u FROM User u WHERE u.dataSkill = 1 AND u.role = 2")
    List<User> findDatabaseCapableResource();

    @Query("SELECT u FROM User u WHERE u.netSkill = 1 AND u.role = 2")
    List<User> findNetworkCapableResource();

    @Query("SELECT u FROM User u WHERE u.mobileSkill = 1 AND u.role = 2")
    List<User> findMobileCapableResource();
}
