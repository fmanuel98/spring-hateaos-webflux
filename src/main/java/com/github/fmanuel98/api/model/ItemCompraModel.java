package com.github.fmanuel98.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "itens_compras")
public class ItemCompraModel extends RepresentationModel<ItemCompraModel> {
  private Long id;
  private Produto produto;
  private String nomeProduto;
  private BigDecimal precoProduto;
  private BigDecimal subTotal;
  private Integer quantidade;
  private LocalDate createdAt;
  private LocalDate updatedAt;

}

@Getter
@Setter
class Produto {
  private Long id;
}