package com.robsonjerlley.dev.cadastro_generico.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactRequestDTO {

    @NotBlank
    @Size(min = 7, max = 12, message = "O campo deve ser preenchido apenas com digitos")
    private String number;
    private String secondNumber;
    @Email(message = "{NotBlank}")
    private String email;

    public ContactRequestDTO() {
    }

    public ContactRequestDTO(String number, String secondNumber, String email) {
        this.number = number;
        this.secondNumber = secondNumber;
        this.email = email;
    }
}