package com.github.fmanuel98.api.model.input;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCompraInput {
  @EqualsAndHashCode.Include
  private Long produtoId;
  private Integer quantidade;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
