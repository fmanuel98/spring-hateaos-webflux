package com.github.fmanuel98.api.disassembler;

import com.github.fmanuel98.api.model.input.CompraInput;
import com.github.fmanuel98.domain.models.Compra;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CompraInputDisassembler {
  private ModelMapper mapper;

  public Compra toDomainObject(CompraInput compraInput) {
    return mapper.map(compraInput, Compra.class);
  }

  public void copyToDomainObject(CompraInput compraInput, Compra produto) {
    mapper.map(compraInput, produto);
  }
}
