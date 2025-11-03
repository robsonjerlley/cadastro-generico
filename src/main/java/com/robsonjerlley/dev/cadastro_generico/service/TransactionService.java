package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.request.TransactionRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {

    TransactionResponseDTO creatForClient(String clientId , TransactionRequestDTO requestDTO);

    List<TransactionResponseDTO> findByClientId(String clientId);



}
