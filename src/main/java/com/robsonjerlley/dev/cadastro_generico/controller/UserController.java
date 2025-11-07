package com.robsonjerlley.dev.cadastro_generico.controller;

import com.robsonjerlley.dev.cadastro_generico.dto.request.UserRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.UserResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO requestDTO) {
        UserResponseDTO newUser = service.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>>findAll(Pageable pageable) {
        Page<UserResponseDTO> userResponseDTOPage = service.findAll(pageable);
        return ResponseEntity.ok(userResponseDTOPage);
    }
}
