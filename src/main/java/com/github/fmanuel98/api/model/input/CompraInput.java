package com.github.fmanuel98.api.model.input;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompraInput {
  @NotNull
  @NotEmpty
  private List<ItemCompraInput> itemsCompra;
  @NotNull
  private Long clienteId;
}
