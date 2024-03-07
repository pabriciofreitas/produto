package com.example.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.produto.entity.Produto;
import com.example.produto.repository.ProdutoRepository;
import com.example.produto.vo.ProdutoVO;

import jakarta.validation.Valid;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(@Valid ProdutoVO produtoVO) {
        var produto = new Produto();
        BeanUtils.copyProperties(produtoVO, produto);
        return produtoRepository.save(produto);
    }

    public ResponseEntity<Object> atualizarProduto(UUID idProduto, @Valid ProdutoVO produtoVO) {
        Optional<Produto> produtoO = produtoRepository.findById(idProduto);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var produto = produtoO.get();
        BeanUtils.copyProperties(produtoVO, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));

    }

    public ResponseEntity<Object> pegarProduto(UUID idProduto) {
        Optional<Produto> produtoO = produtoRepository.findById(idProduto);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoO.get());
    }

    public ResponseEntity<Object> deletarProduto(UUID idProduto) {
        Optional<Produto> produtoO = produtoRepository.findById(idProduto);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepository.deleteById(idProduto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto apagado com sucesso");
    }

    public List<Produto> pegarTodosProduto() {
        return produtoRepository.findAll();
    }
}
