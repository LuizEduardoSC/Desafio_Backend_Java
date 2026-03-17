package com.empresa.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_parceiros")
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_parceiro", nullable = false)
    private String tipoParceiro;

    @Column(nullable = false)
    private String personalidade;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cpf_cnpj", nullable = false, length = 14)
    private String cpfCnpj;

    @Column(nullable = false)
    private String segmento;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false, length = 8)
    private String cep;

    private String pais;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bairro;

    private String complemento;

    @Column(length = 500)
    private String observacao;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String celular;

}
