package com.AnnualProject.April.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.AnnualProject.April.model.TaskAssignment;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {
}