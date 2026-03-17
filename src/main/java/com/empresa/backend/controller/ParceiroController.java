package com.empresa.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.backend.dto.ParceiroDto;
import com.empresa.backend.service.ParceiroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/parceiros")
public class ParceiroController {

    @Autowired
    private ParceiroService parceiroService;

    @PostMapping
    public ResponseEntity<String> cadastrarParceiro(
            @Valid @RequestBody ParceiroDto dto) {
        parceiroService.inserirParceiro(dto);
        return ResponseEntity
                .status(201)
                .body("Parceiro cadastrado com sucesso");
    }
}