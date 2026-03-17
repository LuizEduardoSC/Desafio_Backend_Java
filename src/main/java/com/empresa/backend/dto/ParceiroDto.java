package com.empresa.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ParceiroDto(

		@NotBlank(message = "Tipo de parceiro é obrigatório")
		String tipoParceiro,

		@NotBlank(message = "Personalidade é obrigatória")
		@Pattern(regexp = "Física|Jurídica", message = "Deve ser 'Física' ou 'Jurídica'")
		String personalidade,

		@NotBlank(message = "Razão social é obrigatória")
		@Size(max = 255, message = "Máximo de 255 caracteres")
		String razaoSocial,

		@Size(max = 255, message = "Máximo de 255 caracteres")
		String nomeFantasia,

		@NotBlank(message = "CPF/CNPJ é obrigatório")
		@Pattern(regexp = "(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})|(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}|\\d{14})", message = "CPF (XXX.XXX.XXX-XX) ou CNPJ (XX.XXX.XXX/XXXX-XX) inválido")
		String cpfCnpj,

		@NotBlank(message = "Segmento é obrigatório")
		@Size(max = 100, message = "Máximo de 100 caracteres")
		String segmento,

		@NotBlank(message = "Categoria é obrigatória")
		@Size(max = 100, message = "Máximo de 100 caracteres")
		String categoria,

		@NotBlank(message = "CEP é obrigatório")
		@Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato: XXXXX-XXX")
		String cep,

		String pais,

		@NotBlank(message = "UF é obrigatória")
		@Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
		String uf,

		@NotBlank(message = "Município é obrigatório")
		@Size(max = 100, message = "Máximo de 100 caracteres")
		String municipio,

		@NotBlank(message = "Logradouro é obrigatório")
		@Size(max = 255, message = "Máximo de 255 caracteres")
		String logradouro,

		@NotBlank(message = "Número é obrigatório")
		@Size(max = 10, message = "Máximo de 10 caracteres")
		String numero,

		@NotBlank(message = "Bairro é obrigatório")
		@Size(max = 100, message = "Máximo de 100 caracteres")
		String bairro,

		@Size(max = 255, message = "Máximo de 255 caracteres")
		String complemento,

		@Size(max = 500, message = "Máximo de 500 caracteres")
		String observacao,

		@NotBlank(message = "Email é obrigatório")
		@Email(message = "Email inválido")
		@Size(max = 100, message = "Máximo de 100 caracteres")
		String email,

		@NotBlank(message = "Telefone é obrigatório")
		@Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato: (XX) XXXX-XXXX ou (XX) XXXX-XXXX")
		String telefone,

		@NotBlank(message = "Celular é obrigatório")
		@Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Formato: (XX) XXXXX-XXXX")
		String celular

) {
	// O Record não suporta inicialização inline estilo variável de atributo. 
	// Para garantir que o campo 'pais' tenha valor padrão, podemos criar um construtor compacto:
	public ParceiroDto {
		if (pais == null || pais.isBlank()) {
			pais = "Brasil";
		}
	}
}