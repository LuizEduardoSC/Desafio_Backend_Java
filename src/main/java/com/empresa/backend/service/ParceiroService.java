package com.empresa.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.backend.dto.ParceiroDto;
import com.empresa.backend.entity.Parceiro;
import com.empresa.backend.exception.ParceiroException;
import com.empresa.backend.repository.ParceiroRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParceiroService {

	@Autowired
	private ParceiroRepository parceiroRepository;

	@Transactional
	public Long inserirParceiro(ParceiroDto dto) {
		try {
			log.info("Cadastrando parceiro: {}", dto.razaoSocial());
			
			Parceiro parceiro = new Parceiro();
			parceiro.setTipoParceiro(dto.tipoParceiro());
			parceiro.setPersonalidade(dto.personalidade());
			parceiro.setRazaoSocial(dto.razaoSocial());
			parceiro.setNomeFantasia(dto.nomeFantasia());
			parceiro.setCpfCnpj(dto.cpfCnpj().replaceAll("\\D", "")); // Remove pontuação
			parceiro.setSegmento(dto.segmento());
			parceiro.setCategoria(dto.categoria());
			parceiro.setCep(dto.cep().replace("-", "")); // Remove traço
			parceiro.setPais(dto.pais());
			parceiro.setUf(dto.uf());
			parceiro.setMunicipio(dto.municipio());
			parceiro.setLogradouro(dto.logradouro());
			parceiro.setNumero(dto.numero());
			parceiro.setBairro(dto.bairro());
			parceiro.setComplemento(dto.complemento());
			parceiro.setObservacao(dto.observacao());
			parceiro.setEmail(dto.email());
			parceiro.setTelefone(dto.telefone());
			parceiro.setCelular(dto.celular());

			Parceiro salvo = parceiroRepository.save(parceiro);
			return salvo.getId();

		} catch (DataAccessException e) {
			log.error("Erro ao cadastrar parceiro via JPA: {}", e.getMessage());
			throw new ParceiroException("Falha no cadastro: " + e.getMostSpecificCause().getMessage());
		}
	}
}