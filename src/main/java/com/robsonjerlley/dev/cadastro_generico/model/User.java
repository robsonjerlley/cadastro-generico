package com.robsonjerlley.dev.cadastro_generico.model;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@ToString
@Document(collection = "users")
public class User implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.typeUser == null) {
            return Collections.emptyList();
        }
        return Collections.singleton(new SimpleGrantedAuthority(this.typeUser.name()));
    }


    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
