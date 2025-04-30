package com.AnnualProject.April.controller;

import com.AnnualProject.April.model.User;
import com.AnnualProject.April.model.Role;
import com.AnnualProject.April.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@CrossOrigin(origins = "*") // Allow API testing from any frontend (optional)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = adminService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null); // Returns HTTP 500 if error occurs
        }
    }

    @PutMapping("/{userId}/role")
    public ResponseEntity<?> updateUserRole(@PathVariable Long userId, @RequestParam Role role) {
        try {
            User updatedUser = adminService.updateUserRole(userId, role);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update user role."); // Handles update failure
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        try {
            adminService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete user."); // Handles deletion failure
        }
    }
}