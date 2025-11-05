package com.robsonjerlley.dev.cadastro_generico.dto.response;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponseDTO {

    private String id;
    private String email;
    private String password;
    private TypeUser typeUser;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String id, String email, String password, TypeUser typeUser) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }
}
