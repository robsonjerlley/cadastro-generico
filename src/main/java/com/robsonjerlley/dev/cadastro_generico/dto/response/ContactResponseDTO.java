package com.robsonjerlley.dev.cadastro_generico.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactResponseDTO {
    private String number;
    private String secondNumber;
    private String email;


    public ContactResponseDTO() {
    }

    public ContactResponseDTO(String number, String secondNumber, String email) {
        this.number = number;
        this.secondNumber = secondNumber;
        this.email = email;
    }
}
