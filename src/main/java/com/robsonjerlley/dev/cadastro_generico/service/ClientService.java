package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;


public interface ClientService {

     ClientResponseDTO create(ClientRequestDTO ClientRequest);
     List<ClientResponseDTO> findAll();

     Optional<ClientResponseDTO> findById(String id);

     Optional<ClientResponseDTO> finByCpf(String cpf);

     Optional<ClientResponseDTO> findByNameAndDateOfBirth(String name, OffsetDateTime dateBirth);

     Optional<ClientResponseDTO> update(String id, ClientRequestDTO clientRequest);

     void delete(String id);



}
