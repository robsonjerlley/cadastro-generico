package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.mapper.UserMapper;
import com.robsonjerlley.dev.cadastro_generico.model.User;
import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import com.robsonjerlley.dev.cadastro_generico.repository.UserRepository;
import com.robsonjerlley.dev.cadastro_generico.service.UserDetailsService;
import com.robsonjerlley.dev.cadastro_generico.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        if(userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }
        User newUser = mapper.toEntity(userRequestDTO);
        newUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        newUser.setTypeUser(TypeUser.ROLE_USER);

        User salvedUser = userRepository.save(newUser);

        return mapper.toResponseDTO(salvedUser);
    }

    @Override
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        List<UserResponseDTO> userDTO = userPage.getContent()
                .stream().map(mapper::toResponseDTO)
                .toList();
        return new PageImpl<>(userDTO, pageable,userPage.getTotalElements());
    }


    @Override
    public UserResponseDTO findByEmail(String email) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}
