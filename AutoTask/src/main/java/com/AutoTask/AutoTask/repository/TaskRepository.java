package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT s FROM Task s WHERE s.taskNumber = ?1")
    Optional<Task> findTaskByTaskNumber(int taskNumber);
}
