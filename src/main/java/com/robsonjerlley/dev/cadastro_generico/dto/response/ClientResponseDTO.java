package com.robsonjerlley.dev.cadastro_generico.dto.response;

import com.robsonjerlley.dev.cadastro_generico.model.Address;
import com.robsonjerlley.dev.cadastro_generico.model.Contact;

import java.time.OffsetDateTime;

public class ClientResponseDTO {
    private String name;
    private String cpf;
    private OffsetDateTime dateBirth;
    private AddressResposeDTO addressResposeDTO;
    private ContactResposeDTO contactResposeDTO;


    public ClientResponseDTO() {
    }
}
