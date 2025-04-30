package com.AnnualProject.April.controller;

import com.AnnualProject.April.dto.TaskDTO;
import com.AnnualProject.April.service.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list"; // Redirects to Thymeleaf page
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDTO taskDTO, @AuthenticationPrincipal OAuth2User oauthUser) {
        taskService.createTask(taskDTO, oauthUser);
        return "redirect:/tasks"; // Redirect back to task list after creation
    }
}