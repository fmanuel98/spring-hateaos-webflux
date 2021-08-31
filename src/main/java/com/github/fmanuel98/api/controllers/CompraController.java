package com.github.fmanuel98.api.controllers;

import java.util.Arrays;

import com.github.fmanuel98.api.assembler.CompraModelAssembler;
import com.github.fmanuel98.api.disassembler.CompraInputDisassembler;
import com.github.fmanuel98.api.disassembler.ItemCompraInputDisassembler;
import com.github.fmanuel98.api.model.CompraModel;
import com.github.fmanuel98.api.model.input.CompraInput;
import com.github.fmanuel98.api.model.input.ItemCompraInput;
import com.github.fmanuel98.domain.repositories.CompraRepository;
import com.github.fmanuel98.domain.services.CompraService;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  private ItemCompraInputDisassembler itemCompraInputDisassembler;
  private CompraModelAssembler assembler;

  @GetMapping
  public CollectionModel<CompraModel> listar() {
    var compras = repository.findAll();
    return assembler.toCollectionModel(compras);
  }

  @PostMapping
  public CompraModel salvar(// @Valid @RequestBody CompraInput compraInput
  ) {
    var quantidade = 50;
    var item1 = new ItemCompraInput();
    item1.setProdutoId(1L);
    item1.setQuantidade(quantidade);
    quantidade += 50;
    var itemReal1 = itemCompraInputDisassembler.toDomainObject(item1);
    var item2 = new ItemCompraInput();
    item2.setProdutoId(2L);
    item2.setQuantidade(quantidade);
    var itemReal2 = itemCompraInputDisassembler.toDomainObject(item2);
    var itens = Arrays.asList(itemReal1, itemReal2);
    var compraInput = new CompraInput();
    compraInput.setClienteId(1L);
    // compraInput.setItemsCompra(itens);
    var compra = disassembler.toDomainObject(compraInput);
    compra.setItemsCompra(itens);
    compra = service.salvar(compra);
    return assembler.toModel(compra);
  }
}
