package com.AnnualProject.April.serviceimplementaion;

import com.AnnualProject.April.model.Task;
import com.AnnualProject.April.model.TaskAssignment;
import com.AnnualProject.April.model.User;
import com.AnnualProject.April.repository.TaskAssignmentRepository;
import com.AnnualProject.April.repository.TaskRepository;
import com.AnnualProject.April.repository.UserRepository;
import com.AnnualProject.April.service.TaskAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskAssignmentServiceImpl implements TaskAssignmentService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskAssignmentRepository taskAssignmentRepository;

    @Override
    public void assignTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TaskAssignment taskAssignment = new TaskAssignment();
        taskAssignment.setTask(task);
        taskAssignment.setAssignedUser(user);

        taskAssignmentRepository.save(taskAssignment);
    }
}