package com.AnnualProject.April.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "task_assignments")
public class TaskAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedUser; // User assigned to the task
}