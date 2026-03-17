package com.empresa.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.backend.dto.ParceiroDto;
import com.empresa.backend.exception.ParceiroException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParceiroService {

	@Autowired
	private JdbcTemplate jdbc;

	@Transactional
	public Long inserirParceiro(ParceiroDto dto) {
		String sql = "CALL sp_inserir_parceiro(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			log.info("Cadastrando parceiro: {}", dto.getRazaoSocial());

			jdbc.update(sql, dto.getTipoParceiro(), dto.getPersonalidade(), dto.getRazaoSocial(), dto.getNomeFantasia(),
					dto.getCpfCnpj().replaceAll("\\D", ""), // Remove pontuação
					dto.getSegmento(), dto.getCategoria(), dto.getCep().replace("-", ""), // Remove traço
					dto.getPais(), dto.getUf(), dto.getMunicipio(), dto.getLogradouro(), dto.getNumero(),
					dto.getBairro(), dto.getEmail(), dto.getTelefone(), dto.getCelular(), dto.getComplemento(),
					dto.getObservacao());

			// Retorna o ID gerado (ajuste conforme sua procedure)
			return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

		} catch (DataAccessException e) {
			log.error("Erro ao cadastrar parceiro: {}", e.getMessage());
			throw new ParceiroException("Falha no cadastro: " + e.getMostSpecificCause().getMessage());
		}
	}
}