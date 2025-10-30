package com.robsonjerlley.dev.cadastro_generico.repository;

import com.robsonjerlley.dev.cadastro_generico.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClientRepository extends MongoRepository <Client, String> {

   Optional<Client> findByCpf(String cpf);

   Optional<Client> findByNameAndDateOfBirth(String name, LocalDate dateBirth);


}
