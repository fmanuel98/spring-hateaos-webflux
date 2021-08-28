package com.github.fmanuel98.api.controllers;

import javax.validation.Valid;

import com.github.fmanuel98.api.assembler.CompraModelAssembler;
import com.github.fmanuel98.api.disassembler.CompraInputDisassembler;
import com.github.fmanuel98.api.model.CompraModel;
import com.github.fmanuel98.api.model.input.CompraInput;
import com.github.fmanuel98.domain.repositories.CompraRepository;

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
  private CompraInputDisassembler disassembler;
  private CompraModelAssembler assembler;

  @GetMapping
  public CollectionModel<CompraModel> listar() {
    var compras = repository.findAll();
    return assembler.toCollectionModel(compras);
  }

  @PostMapping
  public CompraModel salvar(@Valid @RequestBody CompraInput compraInput) {
    var compra = disassembler.toDomainObject(compraInput);
    compra = repository.save(compra);
    return assembler.toModel(compra);
  }
}
