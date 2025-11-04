package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.request.TransactionRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.TransactionResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.exceptions.ResourceNotFoundException;
import com.robsonjerlley.dev.cadastro_generico.mapper.TransactionMapper;
import com.robsonjerlley.dev.cadastro_generico.model.Transaction;
import com.robsonjerlley.dev.cadastro_generico.repository.ClientRepository;
import com.robsonjerlley.dev.cadastro_generico.repository.TransactionRepository;
import com.robsonjerlley.dev.cadastro_generico.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;
    private final ClientRepository clientRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  TransactionMapper mapper,ClientRepository clientRepository) {

        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
        this.clientRepository = clientRepository;
    }




    @Override
    public TransactionResponseDTO creatForClient(String clientId, TransactionRequestDTO requestDTO) {
        if(!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("Cliente não encontrado para o ID:" + clientId);
        }
        Transaction transaction = mapper.toEntity(requestDTO);
        transaction.setClientId(clientId);
        transaction.setTransactionDate(OffsetDateTime.now());
        Transaction salvedTransaction = transactionRepository.save(transaction);

        return mapper.toResponseDTO(salvedTransaction);
    }

    @Override
    public List<TransactionResponseDTO> findByClientId(String clientId) {
        List<Transaction> transactions = transactionRepository.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontado para o ID:" + clientId));
        return transactions.stream().map(mapper::toResponseDTO).toList();
    }
}