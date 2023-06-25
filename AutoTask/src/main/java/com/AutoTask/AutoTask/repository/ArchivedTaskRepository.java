package com.AutoTask.AutoTask.repository;

import com.AutoTask.AutoTask.models.ArchivedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivedTaskRepository extends JpaRepository<ArchivedTask, Integer> {
}
