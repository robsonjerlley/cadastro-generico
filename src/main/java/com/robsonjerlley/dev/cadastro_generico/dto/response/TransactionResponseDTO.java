package com.robsonjerlley.dev.cadastro_generico.dto.response;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeTransaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class TransactionResponseDTO {

    private String id;
    private BigDecimal amount;
    private String description;
    private TypeTransaction type;
    private OffsetDateTime transactionDate;

    public TransactionResponseDTO() {
    }

    public TransactionResponseDTO(String id, BigDecimal amount,
                                  String description, TypeTransaction type,
                                  OffsetDateTime transactionDate) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.transactionDate = transactionDate;
    }
}
