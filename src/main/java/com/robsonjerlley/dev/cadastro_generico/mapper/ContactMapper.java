package com.robsonjerlley.dev.cadastro_generico.mapper;

import com.robsonjerlley.dev.cadastro_generico.dto.response.ContactResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactResponseDTO toResponseDTO(Contact entity);
}
