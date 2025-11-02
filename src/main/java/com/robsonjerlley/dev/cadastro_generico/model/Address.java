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
@Document(collection = "endereco")
public class Address {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String zipCode;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;

    public Address() {
    }
}
