package com.github.fmanuel98.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCompraModel {
  private Long id;
  @EqualsAndHashCode.Include
  private ProdutoModel produto;
  private CompraModel compra;
  private String nomeProduto;
  private BigDecimal precoProduto;
  private BigDecimal subTotal;
  private Integer quantidade;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
