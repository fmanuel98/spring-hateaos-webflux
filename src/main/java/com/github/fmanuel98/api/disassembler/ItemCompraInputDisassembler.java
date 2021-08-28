package com.github.fmanuel98.api.disassembler;

import com.github.fmanuel98.api.model.input.ItemCompraInput;
import com.github.fmanuel98.domain.models.ItemCompra;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ItemCompraInputDisassembler {
  private ModelMapper mapper;

  public ItemCompra toDomainObject(ItemCompraInput itemCompraInput) {
    return mapper.map(itemCompraInput, ItemCompra.class);
  }

  public void copyToDomainObject(ItemCompraInput itemCompraInput, ItemCompra produto) {
    mapper.map(itemCompraInput, produto);
  }
}
