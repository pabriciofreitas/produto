package com.example.produto.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.produto.service.ProdutoService;
import com.example.produto.vo.ProdutoVO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoSerProdutoService;

    @PostMapping
    public ResponseEntity<Object> salvarProduto(@RequestBody @Valid ProdutoVO produtoVO) {
        return produtoSerProdutoService.salvarProduto(produtoVO);
    }

    @GetMapping
    public ResponseEntity<Object> pegarTodosProduto() {
        return produtoSerProdutoService.pegarTodosProduto();
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Object> pegarProduto(@PathVariable(value = "idProduto") UUID idProduto) {
        return produtoSerProdutoService.pegarProduto(idProduto);
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value = "idProduto") UUID idProduto) {
        return produtoSerProdutoService.deletarProduto(idProduto);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value = "idProduto") UUID idProduto,
            @RequestBody @Valid ProdutoVO produtoVO) {
        return produtoSerProdutoService.atualizarProduto(idProduto, produtoVO);
    }
}
