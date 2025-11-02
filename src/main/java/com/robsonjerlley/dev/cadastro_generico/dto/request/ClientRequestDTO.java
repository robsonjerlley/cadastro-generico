package com.robsonjerlley.dev.cadastro_generico.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientRequestDTO {

    @NotBlank(message = "{NotBlank}")
    @Size(min = 3, max = 100, message = "{Size}")
    private String name;
    @NotBlank(message = "{NotBlank}")
    @CPF
    private String cpf;

    @NotBlank()
    @Size(min =7, max= 9, message = "O campo deve ser preenchido apenas com os digitos" )
    private String rg;
    @NotNull()
    @Past(message = "Data inválida")
    private LocalDate dateBirth;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String name, String cpf, String rg, LocalDate dateBirth) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.dateBirth = dateBirth;
    }
}
