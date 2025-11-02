package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.LocalDate;
import java.util.List;


public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO ClientRequest);

    Page<ClientResponseDTO> findAll(Pageable pageable);

    ClientResponseDTO findById(String id);

    ClientResponseDTO findByCpf(String cpf);

   List<ClientResponseDTO> findByNameAndDateOfBirth(String name, LocalDate dateBirth);

    ClientResponseDTO update(String id, ClientRequestDTO clientRequest);

    void delete(String id);


}
