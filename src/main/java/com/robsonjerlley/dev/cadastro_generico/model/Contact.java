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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "contato")
public class Contact {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String tell;
    private String secondTell;
    private String email;


    public Contact() {
    }
}
