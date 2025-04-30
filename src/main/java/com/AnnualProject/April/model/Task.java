package com.AnnualProject.April.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status; // PENDING, IN_PROGRESS, COMPLETED

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy; // User who created the task
}