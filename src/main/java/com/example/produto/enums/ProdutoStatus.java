package com.example.produto.enums;

public enum ProdutoStatus {
    ATIVO, ANALISE, DESATIVADO;

    public static ProdutoStatus fromString(String status) {
        switch (status.toUpperCase()) {
            case "ATIVO":
                return ATIVO;
            case "ANALISE":
                return ANALISE;
            case "DESATIVADO":
                return DESATIVADO;
            default:
                throw new IllegalArgumentException("Status desconhecido: " + status);
        }
    }
}
