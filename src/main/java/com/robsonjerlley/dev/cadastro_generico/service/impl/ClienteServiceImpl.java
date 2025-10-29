package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.mapper.ClientMapper;
import com.robsonjerlley.dev.cadastro_generico.model.Client;
import com.robsonjerlley.dev.cadastro_generico.repository.ClienteRepository;
import com.robsonjerlley.dev.cadastro_generico.service.ClientService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClientService {

    private final ClienteRepository clienteRepository;
    private final ClientMapper mapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClientMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }


    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequest) {
        Client toSalve = mapper.toEntity(clientRequest);
        Client salvedClient = clienteRepository.save(toSalve);

        return mapper.toResponseDTO(salvedClient);
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        List<Client> clients = clienteRepository.findAll();

        return clients.stream().map(mapper::toResponseDTO)
                .toList();
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
