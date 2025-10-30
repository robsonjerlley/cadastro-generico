package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;


import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;


public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO ClientRequest);

    List<ClientResponseDTO> findAll();

    ClientResponseDTO findById(String id);

    ClientResponseDTO findByCpf(String cpf);

    ClientResponseDTO findByNameAndDateOfBirth(String name, LocalDate dateBirth);

    ClientResponseDTO update(String id, ClientRequestDTO clientRequest);

    void delete(String id);


}
