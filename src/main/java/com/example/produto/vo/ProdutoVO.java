package com.example.produto.vo;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoVO(@NotBlank String nome, @NotNull BigDecimal valor) {

}
