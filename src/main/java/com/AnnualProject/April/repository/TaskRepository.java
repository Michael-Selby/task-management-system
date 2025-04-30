package com.AnnualProject.April.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.AnnualProject.April.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}