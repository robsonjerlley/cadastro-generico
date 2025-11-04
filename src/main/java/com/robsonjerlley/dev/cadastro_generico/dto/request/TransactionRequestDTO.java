package com.robsonjerlley.dev.cadastro_generico.dto.request;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeTransaction;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class TransactionRequestDTO {

    @NotBlank(message = "${NotBlank}")
    private BigDecimal amount;
    private String description;
    @NotBlank(message = "${NotBlank}")
    private TypeTransaction type;


    public TransactionRequestDTO() {
    }

    public TransactionRequestDTO(BigDecimal amount,
                               String description, TypeTransaction type) {
        this.amount = amount;
        this.description = description;
        this.type = type;

    }
}
