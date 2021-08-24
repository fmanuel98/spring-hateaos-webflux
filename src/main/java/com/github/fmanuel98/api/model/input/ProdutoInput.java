package com.github.fmanuel98.api.model.input;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProdutoInput {
  @NotBlank
  @Size(min = 2, max = 54)
  private String nome;
  @Positive
  private BigDecimal preco;
  @PositiveOrZero
  private Integer quantidade;
  @Future
  private LocalDate dataExpiracao;
}
