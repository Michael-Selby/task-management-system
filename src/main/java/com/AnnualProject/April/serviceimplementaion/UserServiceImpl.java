package com.AnnualProject.April.serviceimplementaion;

import com.AnnualProject.April.dto.UserDTO;
import com.AnnualProject.April.mapper.UserMapper;
import com.AnnualProject.April.model.User;
import com.AnnualProject.April.repository.UserRepository;
import com.AnnualProject.April.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDto(user);
    }
}