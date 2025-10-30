package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.exceptions.ResourceNotFoundException;
import com.robsonjerlley.dev.cadastro_generico.mapper.ClientMapper;
import com.robsonjerlley.dev.cadastro_generico.model.Client;
import com.robsonjerlley.dev.cadastro_generico.repository.ClientRepository;
import com.robsonjerlley.dev.cadastro_generico.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Page<ClientResponseDTO> findAll(Pageable pageable) {
        Page<Client> clientPage = clientRepository.findAll(pageable);
      List<ClientResponseDTO>  clientDTO = clientPage.getContent().stream()
                .map(mapper::toResponseDTO)
                .toList();
       return new PageImpl<>(clientDTO, pageable, clientPage.getTotalElements());
    }


    @Override
    public ClientResponseDTO findById(String id) {
        Client clientFromDb = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID:"+ id));
        return mapper.toResponseDTO(clientFromDb);
    }


    @Override
    public ClientResponseDTO findByCpf(String cpf) {
      Optional<Client> cpfOptional = clientRepository.findByCpf(cpf);
        Client clientFromDb = cpfOptional
                .orElseThrow(()-> new ResourceNotFoundException("CPF não encontrado."));
        return mapper.toResponseDTO(clientFromDb);
    }



    @Override
    public List<ClientResponseDTO> findByNameAndDateOfBirth(String name, LocalDate dateBirth) {
        Optional<Client> clients = clientRepository.findByNameAndDateOfBirth(name, dateBirth);
        return clients.stream()
                .map(mapper::toResponseDTO)
                .toList();
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
