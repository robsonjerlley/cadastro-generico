package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.mapper.UserMapper;
import com.robsonjerlley.dev.cadastro_generico.model.User;
import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import com.robsonjerlley.dev.cadastro_generico.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserMapper mapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Deve criar um usuário a partir de um e-mail nunca utilizados antes no sistema.")
    void creatUser_WithNewEmail_ShoudSucceed() {
        UserRequestDTO requestDTO = new UserRequestDTO();
        requestDTO.setEmail("usuarioTest@test.com");
        requestDTO.setPassword("test102030");

        User mappedUser = new User();
        mappedUser.setEmail("usuarioTest@test.com");
        when(userRepository.findByEmail("usuarioTest@test.com")).thenReturn(Optional.empty());
        when(mapper.toEntity(requestDTO)).thenReturn(mappedUser);
        when(passwordEncoder.encode("test102030")).thenReturn("senha_criptografada_mock");

        userService.create(requestDTO);
        verify(userRepository, times(1)).save(any(User.class));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertNotNull(savedUser);
        assertEquals("usuarioTest@test.com", savedUser.getEmail());
        assertEquals("senha_criptografada_mock", savedUser.getPassword(), "A senha deve ser criptografada");
        assertEquals(TypeUser.ROLE_USER, savedUser.getTypeUser(),"O novo usuário deve ter a ROLE como: ROLE_USER" );

    }





}