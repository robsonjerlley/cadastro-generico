package com.robsonjerlley.dev.cadastro_generico.controller;


import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import com.robsonjerlley.dev.cadastro_generico.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Mock
    private MockMvc mockMvc;
    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Deve retornar status 200 ao criar um usuário.")
    void shouldReturn200WhenCreatingUser()  {
        UserResponseDTO responseDTO = new UserResponseDTO();
        when(userService.create(any())).thenReturn(responseDTO);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        "email":"test@test.com",
                        "password":"test123"
                        }
                        """))
                .andExpect(status().is);

    }

}
