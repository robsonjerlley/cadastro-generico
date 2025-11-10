package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar criar um usuário com um e-mail já resgitrado.")
    void creatUser_WithExistingEmail_ShouldThrowException() {
        UserRequestDTO requestDTO = new UserRequestDTO();
        requestDTO.setEmail("existeEmail@test.com");
        requestDTO.setPassword("exist123");

        when(userRepository.findByEmail("existeEmail@test.com")).thenReturn(Optional.of(new User()));
        assertThrows(IllegalArgumentException.class, () ->
                userService.create(requestDTO));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Deve retornar corretamente uma página de usuários.")
    void findall_ShouldReturnPageOfUsers() {
        Pageable pageable = PageRequest.of(0,10);

        User user1 = new User();
        user1.setId("1");
        user1.setEmail("user1@test.com");
        user1.setPassword("123");
        user1.setTypeUser(TypeUser.valueOf("ROLE_USER"));
        User user2 = new User();
        user2.setId("2");
        user2.setEmail("user2@test.com");
        user2.setPassword("123");
        user2.setTypeUser(TypeUser.valueOf("ROLE_USER"));

        List<User> userList = List.of(user1,user2);
        Page<User> userPage = new PageImpl<>(userList, pageable, userList.size());

        UserResponseDTO dto1 = new UserResponseDTO();
        dto1.setId("1");
        dto1.setEmail("user1@test.com");

        UserResponseDTO dto2 = new UserResponseDTO();
        dto2.setId("2");
        dto2.setEmail("user2@test.com");


        when(userRepository.findAll(any(Pageable.class))).thenReturn(userPage);
        when(mapper.toResponseDTO(user1)).thenReturn(dto1);
        when(mapper.toResponseDTO(user2)).thenReturn(dto2);

        Page<UserResponseDTO> resultPage = userService.findAll(pageable);

        assertNotNull(userPage);
        assertEquals(2, userPage.getTotalElements(), "O número de elementos deve ser (2).");
        assertEquals(2 , userPage.getContent().size(), "O conteúdo da página deve ter (2) usuários.");
        assertTrue(resultPage.getContent().contains(dto1));
        assertTrue(resultPage.getContent().contains(dto2));

        verify(mapper, times(1)).toResponseDTO(user1);
        verify(mapper, times(1)).toResponseDTO(user2);
    }



}