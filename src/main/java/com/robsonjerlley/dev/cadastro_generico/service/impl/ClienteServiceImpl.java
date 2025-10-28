package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.service.ClientService;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClientService {
    @Override
    public ClientResponseDTO create(ClientRequestDTO ClientRequest) {
        return null;
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public Optional<ClientResponseDTO> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientResponseDTO> finByCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientResponseDTO> findByNameAndDateOfBirth(String name, OffsetDateTime dateBirth) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientResponseDTO> update(String id, ClientRequestDTO clientRequest) {
        return Optional.empty();
    }

    @Override
    public void delete(String id) {

    }
}
