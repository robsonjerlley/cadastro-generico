package com.robsonjerlley.dev.cadastro_generico.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AddressResponseDTO {

    private String zipCode;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;

    public AddressResponseDTO() {
    }

    public AddressResponseDTO(String zipCode, String street, String neighborhood,String complement,  String city, String state) {
        this.zipCode = zipCode;
        this.street = street;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }
}
