package com.robsonjerlley.dev.cadastro_generico.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@ToString
@Document(collection = "contato")
public class Contact {
    @Id
    private String id;
    private String number;
    private String secondNumber;
    private String email;


    public Contact() {
    }

    public Contact(String id, String number, String secondNumber, String email) {
        this.id = id;
        this.number = number;
        this.secondNumber = secondNumber;
        this.email = email;
    }
}
