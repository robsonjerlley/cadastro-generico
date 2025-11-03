package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.request.TransactionRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.TransactionResponseDTO;

public interface TransactionService {

    TransactionResponseDTO creatForClient(String clientId , TransactionRequestDTO requestDTO);



}
