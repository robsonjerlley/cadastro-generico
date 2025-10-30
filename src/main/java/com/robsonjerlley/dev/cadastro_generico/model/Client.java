package com.robsonjerlley.dev.cadastro_generico.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@Document(collection = "cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate dateBirth;

    private Address address;
    private Contact contact;
    private String parentTransactionId;

    public Client() {
    }

}
