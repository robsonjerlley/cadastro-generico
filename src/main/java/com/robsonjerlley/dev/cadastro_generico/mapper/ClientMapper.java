package com.robsonjerlley.dev.cadastro_generico.mapper;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.Client;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {AddressMapper.class, ContactMapper.class})
public interface ClientMapper {

    @Mapping(target = "parentTransactionId", ignore = true)
    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientRequestDTO dto);

    ClientResponseDTO toResponseDTO(Client entity);

    @Mapping(target = "parentTransactionId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ClientRequestDTO dto, @MappingTarget Client entity);

}
