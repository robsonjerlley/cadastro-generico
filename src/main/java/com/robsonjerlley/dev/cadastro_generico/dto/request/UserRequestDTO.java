package com.robsonjerlley.dev.cadastro_generico.dto.request;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequestDTO {


    private String email;
    private String password;
    private TypeUser typeUser;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String email, String password, TypeUser typeUser) {
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }
}
