package com.robsonjerlley.dev.cadastro_generico.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AddressRequestDTO {


    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;

    public AddressRequestDTO() {
    }

    public AddressRequestDTO(String cep, String street, String neighborhood, String city, String state) {
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }
}
