package com.robsonjerlley.dev.cadastro_generico.dto.request;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeTransaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Getter
@Setter
@ToString
public class TransactionRequestDTO {


    private BigDecimal amount;
    private String description;
    private TypeTransaction type;
    private OffsetDateTime date;

    public TransactionRequestDTO() {
    }

    public TransactionRequestDTO( BigDecimal amount,
                       String description, TypeTransaction type,
                       OffsetDateTime date) {

        this.amount = amount;
        this.description = description;
        this.type = type;
        this.date = date;
    }
}
