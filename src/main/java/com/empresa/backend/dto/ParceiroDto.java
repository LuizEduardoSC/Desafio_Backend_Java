package com.empresa.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParceiroDto {

	@NotBlank(message = "Tipo de parceiro é obrigatório")
	private String tipoParceiro; // Valores: "Agente Logística", "Cliente", "Despachante", "Fornecedor"

	@NotBlank(message = "Personalidade é obrigatória")
	@Pattern(regexp = "Física|Jurídica", message = "Deve ser 'Física' ou 'Jurídica'")
	private String personalidade;

	@NotBlank(message = "Razão social é obrigatória")
	@Size(max = 255, message = "Máximo de 255 caracteres")
	private String razaoSocial;

	@Size(max = 255, message = "Máximo de 255 caracteres")
	private String nomeFantasia;

	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@Pattern(regexp = "(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})|(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}|\\d{14})", message = "CPF (XXX.XXX.XXX-XX) ou CNPJ (XX.XXX.XXX/XXXX-XX) inválido")
	private String cpfCnpj;

	@NotBlank(message = "Segmento é obrigatório")
	@Size(max = 100, message = "Máximo de 100 caracteres")
	private String segmento;

	@NotBlank(message = "Categoria é obrigatória")
	@Size(max = 100, message = "Máximo de 100 caracteres")
	private String categoria;

	@NotBlank(message = "CEP é obrigatório")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato: XXXXX-XXX")
	private String cep;

	private String pais = "Brasil"; // Valor padrão

	@NotBlank(message = "UF é obrigatória")
	@Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
	private String uf;

	@NotBlank(message = "Município é obrigatório")
	@Size(max = 100, message = "Máximo de 100 caracteres")
	private String municipio;

	@NotBlank(message = "Logradouro é obrigatório")
	@Size(max = 255, message = "Máximo de 255 caracteres")
	private String logradouro;

	@NotBlank(message = "Número é obrigatório")
	@Size(max = 10, message = "Máximo de 10 caracteres")
	private String numero;

	@NotBlank(message = "Bairro é obrigatório")
	@Size(max = 100, message = "Máximo de 100 caracteres")
	private String bairro;

	@Size(max = 255, message = "Máximo de 255 caracteres")
	private String complemento;

	@Size(max = 500, message = "Máximo de 500 caracteres")
	private String observacao;

	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email inválido")
	@Size(max = 100, message = "Máximo de 100 caracteres")
	private String email;

	@NotBlank(message = "Telefone é obrigatório")
	@Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato: (XX) XXXX-XXXX ou (XX) XXXX-XXXX")
	private String telefone;

	@NotBlank(message = "Celular é obrigatório")
	@Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Formato: (XX) XXXXX-XXXX")
	private String celular;
}