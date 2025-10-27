package com.robsonjerlley.dev.cadastro_generico.model;

import com.robsonjerlley.dev.cadastro_generico.model.enums.TypeTransaction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {
    private String id;
    private OffsetDateTime date;
    private BigDecimal value;
    private String description;
    private TypeTransaction type;


}
