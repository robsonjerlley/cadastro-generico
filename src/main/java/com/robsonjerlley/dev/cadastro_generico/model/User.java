package com.robsonjerlley.dev.cadastro_generico.model;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private TypeUser typeUser;

    public User() {
    }

    public User(String id, String email, String password, TypeUser typeUser) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }
}
