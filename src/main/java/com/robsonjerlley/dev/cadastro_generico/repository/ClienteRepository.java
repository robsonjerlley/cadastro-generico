package com.robsonjerlley.dev.cadastro_generico.repository;

import com.robsonjerlley.dev.cadastro_generico.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository <Client, String> {

}
