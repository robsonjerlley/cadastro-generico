package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.exceptions.ResourceNotFoundException;
import com.robsonjerlley.dev.cadastro_generico.mapper.ClientMapper;
import com.robsonjerlley.dev.cadastro_generico.model.Client;
import com.robsonjerlley.dev.cadastro_generico.repository.ClientRepository;
import com.robsonjerlley.dev.cadastro_generico.service.ClientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;


    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }


    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequest) {
        Client toSalve = mapper.toEntity(clientRequest);
        Client salvedClient = clientRepository.save(toSalve);

        return mapper.toResponseDTO(salvedClient);
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(mapper::toResponseDTO)
                .toList();
    }

    @Override
    public ClientResponseDTO findById(String id) {
        Client clientFromDb = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID:"+ id));
        return mapper.toResponseDTO(clientFromDb);
    }


    @Override
    public ClientResponseDTO findByCpf(String cpf) {
        Client cpfFromDb = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("CPF não encontrado."));
        return mapper.toResponseDTO(cpfFromDb);
    }

    @Override
    public ClientResponseDTO findByNameAndDateOfBirth(String name, LocalDate dateBirth) {

        Client nameAndBirthFromDb = clientRepository.findByNameAndDateOfBirth( name, dateBirth)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com base nos dados fornecidos."));
        return mapper.toResponseDTO(nameAndBirthFromDb);
    }



    @Override
    public ClientResponseDTO update(String id, ClientRequestDTO clientRequest) {
        Client clientFromDb = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID" + id));
        mapper.updateEntityFromDto(clientRequest, clientFromDb);

        Client clientUpdate = clientRepository.save(clientFromDb);
        return mapper.toResponseDTO(clientUpdate);
    }

    @Override
    public void delete(String id) {
        Client clientFromDb = clientRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID" + id));
        clientRepository.delete(clientFromDb);

    }


}
