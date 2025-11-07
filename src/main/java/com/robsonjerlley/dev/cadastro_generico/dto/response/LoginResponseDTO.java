package com.robsonjerlley.dev.cadastro_generico.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponseDTO {

    private String token;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
