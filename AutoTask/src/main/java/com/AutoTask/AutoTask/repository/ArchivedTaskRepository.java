package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.ArchivedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArchivedTaskRepository extends JpaRepository<ArchivedTask, Integer> {

    @Query("SELECT s FROM ArchivedTask s WHERE s.taskNumber = ?1")
    Optional<ArchivedTask> findArchivedTaskByTaskNumber(int taskNumber);
}
