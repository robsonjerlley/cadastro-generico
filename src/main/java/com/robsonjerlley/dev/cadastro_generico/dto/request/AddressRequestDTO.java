package com.robsonjerlley.dev.cadastro_generico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressRequestDTO {

    @NotBlank(message = "${NotBalnk}")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos.")
    private String zipCode;

    @NotBlank(message = "A rua é obrigatória.")
    private String street;
    @NotBlank(message = "O bairro é obrigatório.")
    private String neighborhood;

    private String complement;
    @NotBlank(message = "A cidade é obrigatória.")
    private String city;
    @NotBlank(message = "O estado é obrigatório.")
    private String state;

    public AddressRequestDTO() {
    }

    public AddressRequestDTO(String zipCode, String street, String neighborhood, String complement, String city, String state) {
        this.zipCode = zipCode;
        this.street = street;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }
}
