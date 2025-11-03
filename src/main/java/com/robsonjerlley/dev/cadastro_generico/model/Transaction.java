package com.robsonjerlley.dev.cadastro_generico.model;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeTransaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@Document(collection = "transacao")
public class Transaction {

    @Id
    private String id;
    private BigDecimal amount;
    private String description;
    private TypeTransaction type;
    private OffsetDateTime transactionDate;
    private String clientId;

    public Transaction() {
    }

    public Transaction(String id, BigDecimal amount,
                       String description, TypeTransaction type,
                       OffsetDateTime transactionDate, String clientId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.transactionDate = transactionDate;
        this.clientId = clientId;
    }
}
