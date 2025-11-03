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
@Document(collection = "endereco")
public class Address {
    @Id
    private String id;
    private String zipCode;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String id, String zipCode, String street,
                   String neighborhood, String complement,
                   String city, String state) {

        this.id = id;
        this.zipCode = zipCode;
        this.street = street;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }
}
