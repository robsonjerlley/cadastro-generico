package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.exceptions.ResourceNotFoundException;
import com.robsonjerlley.dev.cadastro_generico.mapper.AddressMapper;
import com.robsonjerlley.dev.cadastro_generico.mapper.ClientMapper;
import com.robsonjerlley.dev.cadastro_generico.mapper.ContactMapper;
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
    private final ClientMapper clientMapper;
    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;


    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper,
                             AddressMapper addressMapper, ContactMapper contactMapper) {

        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
    }


    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequest) {
        Client toSalve = clientMapper.toEntity(clientRequest);
        Client salvedClient = clientRepository.save(toSalve);

        return clientMapper.toResponseDTO(salvedClient);
    }

    @Override
    public Page<ClientResponseDTO> findAll(Pageable pageable) {
        Page<Client> clientPage = clientRepository.findAll(pageable);
      List<ClientResponseDTO>  clientDTO = clientPage.getContent().stream()
                .map(clientMapper::toResponseDTO)
                .toList();
       return new PageImpl<>(clientDTO, pageable, clientPage.getTotalElements());
    }


    @Override
    public ClientResponseDTO findById(String id) {
        Client clientFromDb = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID:"+ id));
        return clientMapper.toResponseDTO(clientFromDb);
    }


    @Override
    public ClientResponseDTO findByCpf(String cpf) {
      Optional<Client> cpfOptional = clientRepository.findByCpf(cpf);
        Client clientFromDb = cpfOptional
                .orElseThrow(()-> new ResourceNotFoundException("CPF não encontrado."));
        return clientMapper.toResponseDTO(clientFromDb);
    }



    @Override
    public List<ClientResponseDTO> findByNameAndDateOfBirth(String name, LocalDate dateBirth) {
        Optional<Client> clients = clientRepository.findByNameAndDateBirth(name, dateBirth);
        return clients.stream()
                .map(clientMapper::toResponseDTO)
                .toList();
    }



    @Override
    public ClientResponseDTO update(String id, ClientRequestDTO clientRequest) {
        Client clientFromDb = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID" + id));
        clientMapper.updateEntityFromDto(clientRequest, clientFromDb);

        Client clientUpdate = clientRepository.save(clientFromDb);
        System.out.println("ClienteResponseDTO recebido: " + clientRequest);
        return clientMapper.toResponseDTO(clientUpdate);

    }

    @Override
    public void delete(String id) {
        Client clientFromDb = clientRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID" + id));
        clientRepository.delete(clientFromDb);

    }


}
