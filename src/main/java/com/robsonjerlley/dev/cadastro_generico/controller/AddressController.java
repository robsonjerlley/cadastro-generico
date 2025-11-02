package com.robsonjerlley.dev.cadastro_generico.controller;

import com.robsonjerlley.dev.cadastro_generico.dto.response.AddressResponseDTO;
import com.robsonjerlley.dev.cadastro_generico.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }
    @GetMapping("/cep/{cep}")
    public ResponseEntity<AddressResponseDTO> getAddressByCep(
            @PathVariable String cep) {
        AddressResponseDTO dto = service.findByCep(cep);
       return ResponseEntity.ok(dto);
    }


}
