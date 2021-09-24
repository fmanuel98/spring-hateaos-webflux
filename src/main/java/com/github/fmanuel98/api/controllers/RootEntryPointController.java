package com.github.fmanuel98.api.controllers;

import com.github.fmanuel98.api.HateoasWebfluxLinks;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RootEntryPointController {
  private HateoasWebfluxLinks links;

  @GetMapping
  public RootEntryPointModel root() {
    var rootEntryPointModel = new RootEntryPointModel();
    rootEntryPointModel.add(links.linkToProdutos("produtos"));
    rootEntryPointModel.add(links.linkToClientes("clientes"));
    rootEntryPointModel.add(links.linkToCompras("compras"));
    rootEntryPointModel.add(links.linkToProdutoMaisVendidos());
    return rootEntryPointModel;
  }

  private static class RootEntryPointModel extends RepresentationModel<RootEntryPointModel> {
  }
}
