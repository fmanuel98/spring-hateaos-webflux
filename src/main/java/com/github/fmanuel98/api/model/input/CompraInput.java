package com.github.fmanuel98.api.model.input;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompraInput {
  private List<ItemCompraInput> itemsCompra;
  private Long clienteId;
  private BigDecimal total;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
