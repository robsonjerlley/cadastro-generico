package com.robsonjerlley.dev.cadastro_generico.model;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeTransaction;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "transacao")
public class Transaction {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private OffsetDateTime date;
    private BigDecimal value;
    private String description;
    private TypeTransaction type;

    public Transaction() {
    }
}
