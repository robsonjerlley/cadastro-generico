package com.robsonjerlley.dev.cadastro_generico.repository;

import com.robsonjerlley.dev.cadastro_generico.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

   Optional<List<Transaction>> findByClientId(String clientId);

}
