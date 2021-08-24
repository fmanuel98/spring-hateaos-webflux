package com.github.fmanuel98.api.controllers;

import javax.validation.Valid;

import com.github.fmanuel98.api.assembler.ProdutoModelAssembler;
import com.github.fmanuel98.api.disassembler.ProdutoInputDisassembler;
import com.github.fmanuel98.api.model.ProdutoModel;
import com.github.fmanuel98.api.model.input.ProdutoInput;
import com.github.fmanuel98.domain.models.Produto;
import com.github.fmanuel98.domain.repositories.ProdutoRepository;
import com.github.fmanuel98.domain.services.ProdutoService;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {
  private ProdutoService service;
  private ProdutoRepository repository;
  private ProdutoInputDisassembler disassembler;
  private ProdutoModelAssembler assembler;

  @GetMapping
  public CollectionModel<ProdutoModel> listar() {
    var produtos = repository.findAll();
    return assembler.toCollectionModel(produtos);
  }

  @PostMapping
  public Produto salvar(@Valid @RequestBody ProdutoInput produtoInput) {
    var produto = disassembler.toDomainObject(produtoInput);
    return service.salvar(produto);
  }

  @PutMapping("/{produtoId}")
  public Produto actualizar(@Valid @RequestBody ProdutoInput produtoInput, @PathVariable Long produtoId) {
    var produtoReal = service.buscarOrFalhar(produtoId);
    disassembler.copyToDomainObject(produtoInput, produtoReal);
    return service.salvar(produtoReal);
  }

}
