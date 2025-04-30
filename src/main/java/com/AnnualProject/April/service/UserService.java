package com.AnnualProject.April.service;

import com.AnnualProject.April.dto.UserDTO;

public interface UserService {
    UserDTO findUserByEmail(String email);
}