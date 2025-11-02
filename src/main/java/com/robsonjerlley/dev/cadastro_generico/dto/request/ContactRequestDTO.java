package com.robsonjerlley.dev.cadastro_generico.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContactRequestDTO {

    @NotBlank
    @Size(min = 7, max = 12, message = "O campo deve ser preenchido apenas com digitos")
    private String tell;
    @NotBlank
    @Size(min = 7, max = 12, message = "O campo deve ser preenchido apenas com digitos")
    private String secondTell;
    @Email(message = "{NotBlank}")
    private String email;

    public ContactRequestDTO() {
    }

    public ContactRequestDTO(String tell, String secondTell, String email) {
        this.tell = tell;
        this.secondTell = secondTell;
        this.email = email;
    }
}
