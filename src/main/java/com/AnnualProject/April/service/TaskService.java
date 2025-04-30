package com.AnnualProject.April.service;

import com.AnnualProject.April.dto.TaskDTO;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO, OAuth2User oauthUser); // Include OAuth parameter
    List<TaskDTO> getAllTasks();
}