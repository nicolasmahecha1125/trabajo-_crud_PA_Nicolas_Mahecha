package com.utadeo.taskapp.repository;

import com.utadeo.taskapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task,Long> {
    Task findByTitle(String title);
}
