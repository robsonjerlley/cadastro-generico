package com.robsonjerlley.dev.cadastro_generico.mapper;

import com.robsonjerlley.dev.cadastro_generico.dto.request.AddressRequestDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.AddressResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.gateway.dto.ViaCepGatewayResponse;
import com.robsonjerlley.dev.cadastro_generico.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressRequestDTO dto);
    AddressResponseDTO toResponseDTO(Address entity);

    @Mappings({
      @Mapping(source ="cep", target = "zipCode"),
      @Mapping(source = "logradouro", target = "street"),
      @Mapping(source = "bairro", target = "neighborhood"),
      @Mapping(source = "complemento" , target = "complement"),
      @Mapping(source = "localidade", target = "city"),
      @Mapping(source = "uf", target = "state")
    })AddressResponseDTO formGatewayToResponseDTO(ViaCepGatewayResponse gatewayResponse);

}
