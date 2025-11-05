package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> findAll();

    UserResponseDTO findByEmail(String email);

}
