package com.robsonjerlley.dev.cadastro_generico.mapper;

import com.robsonjerlley.dev.cadastro_generico.dto.response.AddressResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressResponseDTO toResponseDTO(Address entity);
}
