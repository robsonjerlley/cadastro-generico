package com.robsonjerlley.dev.cadastro_generico.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ClientResponseDTO {
    private String name;
    private String cpf;
    private OffsetDateTime dateBirth;


    private AddressResponseDTO address;
    private ContactResponseDTO contact;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(String name, String cpf, OffsetDateTime dateBirth,
                             AddressResponseDTO address, ContactResponseDTO contact) {
        this.name = name;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
        this.address = address;
        this.contact = contact;
    }
}
