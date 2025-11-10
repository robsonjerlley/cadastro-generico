package com.robsonjerlley.dev.cadastro_generico.controller;

// --- IMPORTS CORRETOS ---
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robsonjerlley.dev.cadastro_generico.config.security.SecurityConfig;
import com.robsonjerlley.dev.cadastro_generico.config.security.TokenService;
import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.repository.UserRepository;
import com.robsonjerlley.dev.cadastro_generico.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// ---------------------------

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private UserService userService;
    @MockitoBean
    private TokenService tokenService;
    @MockitoBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Deve criar um usuário e retornar 201 Created quando dados válidos são fornecidos")
    void createUser_WithValidData_ShouldReturn201() throws Exception {

        UserRequestDTO requestDTO = new UserRequestDTO();
        requestDTO.setEmail("teste@test.com");
        requestDTO.setPassword("senha123");

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId("123");
        responseDTO.setEmail("teste@test.com");

        when(userService.create(any(UserRequestDTO.class))).thenReturn(responseDTO);

        // --- ACT & ASSERT ---
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.email").value("teste@test.com"));
    }

    @Test
    @DisplayName("Deve retornar 403 ao tentar listar usuários sem autentificação")
    void findAll_WithAuthentication_ShoudReturn403() throws Exception {

        mockMvc.perform(get("/users")).andExpect(status().isForbidden());
    }
}