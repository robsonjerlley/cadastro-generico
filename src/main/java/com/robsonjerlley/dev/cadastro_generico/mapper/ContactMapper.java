package com.robsonjerlley.dev.cadastro_generico.mapper;

import com.robsonjerlley.dev.cadastro_generico.dto.request.ContactRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ContactResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactRequestDTO requestDTO);
    ContactResponseDTO toResponseDTO(Contact entity);
}
