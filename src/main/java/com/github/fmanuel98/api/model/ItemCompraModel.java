package com.github.fmanuel98.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;

@Data
@Relation(collectionRelation = "itens_compras")
public class ItemCompraModel extends RepresentationModel<ItemCompraModel> {
  private Long id;
  private ProdutoModel produto;
  private CompraModel compra;
  private String nomeProduto;
  private BigDecimal precoProduto;
  private BigDecimal subTotal;
  private Integer quantidade;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
