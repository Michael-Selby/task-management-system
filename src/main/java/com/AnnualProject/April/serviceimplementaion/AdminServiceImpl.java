package com.AnnualProject.April.serviceimplementaion;

import com.AnnualProject.April.model.User;
import com.AnnualProject.April.model.Role;
import com.AnnualProject.April.repository.UserRepository;
import com.AnnualProject.April.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserRole(Long userId, Role role) {
        return userRepository.findById(userId).map(user -> {
            user.setRole(role);
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}