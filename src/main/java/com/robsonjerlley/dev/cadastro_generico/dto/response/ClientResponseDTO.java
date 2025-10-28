package com.robsonjerlley.dev.cadastro_generico.dto.response;

import com.robsonjerlley.dev.cadastro_generico.model.Address;
import com.robsonjerlley.dev.cadastro_generico.model.Contact;
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
    private AddressResponseDTO addressResponseDTO;
    private ContactResposenDTO contactResponseDTO;


    public ClientResponseDTO() {
    }

    public ClientResponseDTO(String name, String cpf, OffsetDateTime dateBirth, AddressResponseDTO addressResponseDTO, ContactResposenDTO contactResponseDTO) {
        this.name = name;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
        this.addressResponseDTO = addressResponseDTO;
        this.contactResponseDTO = contactResponseDTO;
    }
}
