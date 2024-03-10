package com.example.produto.entity;

import com.example.produto.enums.ProdutoStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "tb_produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Long idProduto;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProdutoStatus status;

}
