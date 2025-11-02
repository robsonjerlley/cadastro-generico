package com.robsonjerlley.dev.cadastro_generico.service;

import com.robsonjerlley.dev.cadastro_generico.dto.response.AddressResponseDTO;

public interface AddressService {
  AddressResponseDTO findByCep(String zipCode);

}
