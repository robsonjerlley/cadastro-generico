package com.robsonjerlley.dev.cadastro_generico.repository;

import com.robsonjerlley.dev.cadastro_generico.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
