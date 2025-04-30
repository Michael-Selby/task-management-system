package com.AnnualProject.April.controller;

import com.AnnualProject.April.service.TaskAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    @PostMapping("/tasks/assign")
    public String assignTask(@RequestParam Long taskId, @RequestParam Long userId) {
        taskAssignmentService.assignTask(taskId, userId);
        return "redirect:/tasks";
    }
}