package com.example.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.produto.entity.Produto;
import com.example.produto.repository.ProdutoRepository;
import com.example.produto.vo.ProdutoVO;

import jakarta.validation.Valid;

@SuppressWarnings("null")

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<Object> salvarProduto(@Valid ProdutoVO produtoVO) {
        var produto = produtoRepository.save(produtoVOParaProduto(produtoVO));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProdutoVO(produto));
    }

    public ResponseEntity<Object> atualizarProduto(Long idProduto, @Valid ProdutoVO produtoVO) {
        Optional<Produto> produtoO = produtoRepository.findById(idProduto);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoVO.setIdProduto(idProduto);
        var produto = produtoVOParaProduto(produtoVO);
        return ResponseEntity.status(HttpStatus.OK).body(new ProdutoVO(produtoRepository.save(produto)));

    }

    public ResponseEntity<Object> pegarProduto(Long idProduto) {
        Optional<Produto> produtoO = produtoRepository.findById(idProduto);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ProdutoVO(produtoO.get()));
    }

    public ResponseEntity<Object> deletarProduto(Long idProduto) {
        Optional<Produto> produtoO = produtoRepository.findById(idProduto);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepository.deleteById(idProduto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto apagado com sucesso");
    }

    public ResponseEntity<Object> pegarTodosProduto() {
        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoVO> produtosVO = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosVO.add(new ProdutoVO(produto));
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtosVO);
    }

    public Produto produtoVOParaProduto(ProdutoVO produtoVO) {
        var newProduto = new Produto();
        newProduto.setNome(produtoVO.getNome());
        newProduto.setValor(produtoVO.getValor());
        newProduto.setStatus(produtoVO.getStatus());
        if (produtoVO.getIdProduto() != null) {
            newProduto.setIdProduto(produtoVO.getIdProduto());
        }
        return newProduto;
    }
}
