package com.robsonjerlley.dev.cadastro_generico.repository;

import com.robsonjerlley.dev.cadastro_generico.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
