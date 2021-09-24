package com.github.fmanuel98.api.controllers;

import java.util.stream.Collectors;

import javax.validation.Valid;

import com.github.fmanuel98.api.assembler.CompraModelAssembler;
import com.github.fmanuel98.api.assembler.ProdutoModelAssembler;
import com.github.fmanuel98.api.disassembler.CompraInputDisassembler;
import com.github.fmanuel98.api.disassembler.ItemCompraInputDisassembler;
import com.github.fmanuel98.api.model.CompraModel;
import com.github.fmanuel98.api.model.ProdutoModel;
import com.github.fmanuel98.api.model.input.CompraInput;
import com.github.fmanuel98.domain.repositories.CompraRepository;
import com.github.fmanuel98.domain.services.CompraService;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class CompraController {
  private CompraRepository repository;
  private CompraService service;
  private CompraInputDisassembler disassembler;
  private ItemCompraInputDisassembler itemInputDisassembler;
  private CompraModelAssembler assembler;
  private ProdutoModelAssembler produtoModelAssembler;

  @GetMapping
  public CollectionModel<CompraModel> listar() {
    var compras = repository.findAll();
    return assembler.toCollectionModel(compras);
  }

  @GetMapping("/produtos-mais-vendidos")
  public CollectionModel<ProdutoModel> produtosMaisVendidos() {
    var produtos = service.produtoMaisVendidos();
    return produtoModelAssembler.toCollectionModel(produtos);
  }

  @PostMapping
  public CompraModel salvar(@Valid @RequestBody CompraInput compraInput) {
    final var itens = compraInput.getItemsCompra().stream()
        .map(itemInput -> itemInputDisassembler.toDomainObject(itemInput)).collect(Collectors.toList());
    var compra = disassembler.toDomainObject(compraInput);
    compra.setItemsCompra(itens);
    compra = service.salvar(compra);
    return assembler.toModel(compra);
  }
}
