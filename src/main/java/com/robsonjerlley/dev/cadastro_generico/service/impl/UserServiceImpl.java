package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        return null;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        return null;
    }
}
