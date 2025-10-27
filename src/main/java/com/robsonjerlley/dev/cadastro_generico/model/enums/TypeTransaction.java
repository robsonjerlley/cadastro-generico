package com.robsonjerlley.dev.cadastro_generico.model.enums;

import lombok.Getter;

@Getter
public enum TypeTransaction {
    SERVICE("serviço"),
    PURCHASE("compra");

    private final String description;
    TypeTransaction(String description) {
        this.description = description;
    }



}
