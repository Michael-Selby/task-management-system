package com.AnnualProject.April.service;

import com.AnnualProject.April.model.User;
import com.AnnualProject.April.model.Role;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers(); // Admin can view all users
    User updateUserRole(Long userId, Role role); // Admin can assign roles
    void deleteUser(Long userId); // Admin can remove users
}