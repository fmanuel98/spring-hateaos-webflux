package com.github.fmanuel98.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "produtos")
public class ProdutoModel extends RepresentationModel<ProdutoModel> {
  private Long id;
  private String nome;
  private BigDecimal preco;
  private Integer quantidade;
  private LocalDate dataExpiracao;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
