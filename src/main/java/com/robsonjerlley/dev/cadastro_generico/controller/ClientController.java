package com.robsonjerlley.dev.cadastro_generico.controller;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientRequestDTO requestDTO) {
        ClientResponseDTO creatClient = service.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatClient);
    }
    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> findAll(Pageable pageable) {
        Page<ClientResponseDTO> clientPage = service.findAll(pageable);
        return ResponseEntity.ok(clientPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable String id) {
        ClientResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClientResponseDTO> findByCpf(@PathVariable String cpf) {
        ClientResponseDTO dto = service.findByCpf(cpf);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClientResponseDTO>> finByNameAndDateOfBirth(
            @PathVariable
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dateBirth) {

        List<ClientResponseDTO> clients = service.findByNameAndDateOfBirth(name, dateBirth);
        return ResponseEntity.ok(clients);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(
            @PathVariable
            @RequestBody
            @Valid String id, ClientRequestDTO requestDTO) {
        ClientResponseDTO clientUpdate = service.update(id, requestDTO);

        return ResponseEntity.ok().body(clientUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> delete(@PathVariable String id) {
       service.delete(id);
       return ResponseEntity.noContent().build();
    }


}
