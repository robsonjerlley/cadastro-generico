package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.response.AddressResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.gateway.dto.ViaCepGatewayResponse;
import com.robsonjerlley.dev.cadastro_generico.gateway.ViaCepGateway;
import com.robsonjerlley.dev.cadastro_generico.mapper.AddressMapper;
import com.robsonjerlley.dev.cadastro_generico.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final ViaCepGateway viaCepGateway;
    private final AddressMapper mapper;

    public AddressServiceImpl(ViaCepGateway viaCepGateway, AddressMapper mapper) {
        this.viaCepGateway = viaCepGateway;
        this.mapper = mapper;
    }


    @Override
    public AddressResponseDTO findByCep(String zipCode) {
        String validCep = zipCode.replace("[^0-9 ]", "");
        if(validCep.length() != 8) {
            throw new IllegalArgumentException("CEP não encontrado" + zipCode);
        }
        ViaCepGatewayResponse gatewayResponse = viaCepGateway.findByCep(validCep).block();

        if(gatewayResponse == null || gatewayResponse.isErro()) {
            throw new IllegalArgumentException("CEP não encontrado" + zipCode);

        }
        return mapper.formGatewayToResponseDTO(gatewayResponse);
    }



}
