package com.robsonjerlley.dev.cadastro_generico.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@Document(collection = "cliente")
public class Client {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String cpf;
    private String rg;
    private LocalDate dateBirth;

    private Address address;
    private Contact contact;
    private String parentTransactionId;

    public Client() {
    }

    public Client(String id, String name, String cpf, String rg,
                  LocalDate dateBirth, Address address,
                  Contact contact, String parentTransactionId) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.dateBirth = dateBirth;
        this.address = address;
        this.contact = contact;
        this.parentTransactionId = parentTransactionId;
    }
}
