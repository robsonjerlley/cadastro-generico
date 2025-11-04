package com.robsonjerlley.dev.cadastro_generico.mapper;


import com.robsonjerlley.dev.cadastro_generico.dto.request.TransactionRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.TransactionResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "clientId", ignore = true),
            @Mapping(target = "transactionDate", ignore = true)
    })
    Transaction toEntity(TransactionRequestDTO dto);

    @Mapping(target = "transactionDate", ignore = true)
    TransactionResponseDTO toResponseDTO(Transaction entity);


}
