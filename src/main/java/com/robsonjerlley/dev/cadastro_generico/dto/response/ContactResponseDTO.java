package com.robsonjerlley.dev.cadastro_generico.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContactResponseDTO {
    private String tell;
    private String secondTell;
    private String email;


    public ContactResponseDTO() {
    }

    public ContactResponseDTO(String tell, String secondTell, String email) {
        this.tell = tell;
        this.secondTell = secondTell;
        this.email = email;
    }
}
