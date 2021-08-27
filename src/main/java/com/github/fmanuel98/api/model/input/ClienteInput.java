package com.github.fmanuel98.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClienteInput {
  @Size(min = 2, max = 25)
  private String nome;
  @Email
  @Size(min = 10, max = 75)
  private String email;
  @Positive
  @NotNull
  private BigDecimal money;
}
