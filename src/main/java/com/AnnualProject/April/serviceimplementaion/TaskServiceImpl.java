package com.AnnualProject.April.serviceimplementaion;

import com.AnnualProject.April.dto.TaskDTO;
import com.AnnualProject.April.mapper.TaskMapper;
import com.AnnualProject.April.model.Task;
import com.AnnualProject.April.model.User;
import com.AnnualProject.April.repository.TaskRepository;
import com.AnnualProject.April.repository.UserRepository;
import com.AnnualProject.April.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO, OAuth2User oauthUser) {
        String email = oauthUser.getAttribute("email"); // Get authenticated user email

        User admin = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Task task = taskMapper.toEntity(taskDTO);
        task.setCreatedBy(admin); // Automatically assign the creator

        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }
}