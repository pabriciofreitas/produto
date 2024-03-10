package com.example.produto.vo;

import java.math.BigDecimal;

import com.example.produto.entity.Produto;
import com.example.produto.enums.ProdutoStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@JsonPropertyOrder({
        "IdProduto",
        "nome",
        "valor",
        "status",
        "dataDeCriacao",
        "dataDaUltimaAtualizacao",
})
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProdutoVO {
    Long IdProduto;
    @NotBlank(message = "O nome do produto não pode ser vazio ou nulo.")
    String nome;
    @NotNull(message = "O valor do produto inválido.")
    BigDecimal valor;
    @NotNull(message = "Status do produto inválido")
    ProdutoStatus status;

    Date dataDeCriacao;
    Date dataDaUltimaAtualizacao;

    public ProdutoVO() {
    }

    public ProdutoVO(Produto produto) {
        if (produto == null) {
            return;
        }
        this.IdProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.status = produto.getStatus();
        this.dataDeCriacao = produto.getDataDeCriacao();
        this.dataDaUltimaAtualizacao = produto.getDataDaUltimaAtualizacao();
    }

    public void setStatus(String status) {
        this.status = ProdutoStatus.fromString(status);
    }

}
