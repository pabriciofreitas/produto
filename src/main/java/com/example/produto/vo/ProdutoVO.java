package com.example.produto.vo;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import com.example.produto.entity.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonPropertyOrder({
        "IdProduto",
        "nome",
        "valor"
})
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProdutoVO {
    UUID IdProduto;
    @NotBlank
    String nome;
    @NotNull
    BigDecimal valor;

    public Produto transformaEmProduto(Optional<Produto> produto) {
        var newProduto = new Produto();
        newProduto.setNome(this.nome);
        newProduto.setValor(this.valor);
        if (produto != null && produto.isPresent()) {
            newProduto.setIdProduto(produto.get().getIdProduto());
        }
        return newProduto;
    }

    public ProdutoVO() {
    }

    public ProdutoVO(Produto produto) {
        if (produto == null) {
            return;
        }
        this.IdProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
