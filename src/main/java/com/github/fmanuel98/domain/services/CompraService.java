package com.github.fmanuel98.domain.services;

import com.github.fmanuel98.domain.models.Compra;
import com.github.fmanuel98.domain.models.ItemCompra;
import com.github.fmanuel98.domain.models.Produto;
import com.github.fmanuel98.domain.repositories.CompraRepository;
import com.github.fmanuel98.domain.repositories.ItemCompraRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CompraService {
  private CompraRepository repository;
  private ItemCompraRepository itemCompraRepository;

  public Compra salvar(Compra compra) {
    final var compraReal = repository.save(compra);
    compra.getItemsCompra().forEach(item -> {
      item.setCompra(compraReal);
      var produto = verificarQuantidadeEmStock(item);
      item.setProduto(produto);
      itemCompraRepository.save(item);

    });
    return compraReal;
  }

  private final Produto verificarQuantidadeEmStock(ItemCompra item) {
    var produto = item.getProduto();
    int quantidadeDisponivel = produto.getQuantidade();
    int quantidadeDesejada = item.getQuantidade();
    int quantidadeRestante = quantidadeDisponivel - quantidadeDesejada;
    if (quantidadeRestante < 0) {
      log.info("quantidade negativa");
    }
    produto.setQuantidade(quantidadeRestante);
    return produto;
  }
}
