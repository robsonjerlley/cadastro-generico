package com.robsonjerlley.dev.cadastro_generico.controller;

import com.robsonjerlley.dev.cadastro_generico.dto.request.TransactionRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.TransactionResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private final TransactionService service;


    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/clients/{clientId}/transactions")
    public ResponseEntity<TransactionResponseDTO> creatTransaction(
            @PathVariable String clientId,
            @RequestBody TransactionRequestDTO requestDTO) {

        TransactionResponseDTO creatTransaction = service.creatForClient(clientId, requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatTransaction);
    }

    @GetMapping("/clients/{clientId}/transactions")
    public ResponseEntity<List<TransactionResponseDTO>> getAllByClientId(@PathVariable String clientId) {
        List<TransactionResponseDTO> transactions = service.findByClientId(clientId);

        return ResponseEntity.ok(transactions);
    }
}
