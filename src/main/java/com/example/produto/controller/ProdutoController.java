package com.example.produto.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.produto.entity.Produto;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvarProduto(@RequestBody @Valid ProdutoVO produtoVO) {
        return produtoSerProdutoService.salvarProduto(produtoVO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> pegarTodosProduto() {
        return produtoSerProdutoService.pegarTodosProduto();
    }

    @GetMapping("/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> pegarProduto(@PathVariable(value = "idProduto") UUID idProduto) {
        return produtoSerProdutoService.pegarProduto(idProduto);
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value = "idProduto") UUID idProduto) {
        return produtoSerProdutoService.deletarProduto(idProduto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{idProduto}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value = "idProduto") UUID idProduto,
            @RequestBody @Valid ProdutoVO produtoVO) {
        return produtoSerProdutoService.atualizarProduto(idProduto, produtoVO);
    }
}
