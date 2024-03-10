package com.example.produto.entity;

import com.example.produto.enums.ProdutoStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @Column(name = "data_de_criacao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dataDeCriacao;
    @Column(name = "data_da_ultima_atualizacao", nullable = false)
    @LastModifiedDate
    private Date dataDaUltimaAtualizacao;

    @PreUpdate
    protected void preUpdate() {
        this.dataDaUltimaAtualizacao = new Date();
    }

    @PrePersist
    protected void onCreate() {
        this.dataDeCriacao = new Date();
        this.dataDaUltimaAtualizacao = new Date();

    }
}
