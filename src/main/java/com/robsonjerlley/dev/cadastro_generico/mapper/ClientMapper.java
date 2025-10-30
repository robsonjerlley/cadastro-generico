package com.robsonjerlley.dev.cadastro_generico.mapper;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ClientRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ClientResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = {AddressMapper.class, ContactMapper.class})
public interface ClientMapper {

    Client toEntity(ClientRequestDTO dto);

    ClientResponseDTO toResponseDTO(Client entity);

    void updateEntityFromDto(ClientRequestDTO dto, @MappingTarget Client entity);

}
