package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.dto.response.AddressResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.dto.response.ViaCepResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.gateway.ViaCepGateway;
import com.robsonjerlley.dev.cadastro_generico.service.AddressService;

public class AddressServiceImpl implements AddressService {

    private final ViaCepGateway viaCepGateway;

    public AddressServiceImpl(ViaCepGateway viaCepGateway) {
        this.viaCepGateway = viaCepGateway;
    }


    @Override
    public AddressResponseDTO findByCep(String cep) {
        String validCep = cep.replace("[^0-9 ]", "");
        if(validCep.length() != 8) {
            throw new IllegalArgumentException("CEP não encontrado" + cep);
        }
        ViaCepResponseDTO viaCepDTO = viaCepGateway.findByCep(validCep).block();

        if(validCep == null || viaCepDTO.isErro()) {
            throw new IllegalArgumentException("CEP não encontrado" + cep);

        }

        return converToAddressResponseDTO(viaCepDTO);
    }
}
