package com.github.fmanuel98.api.controllers;

import java.util.List;

import com.github.fmanuel98.domain.models.Compra;
import com.github.fmanuel98.domain.repositories.CompraRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class CompraController {
  private CompraRepository repository;

  public List<Compra> listar() {
    return repository.findAll();
  }
}
