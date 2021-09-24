package com.github.fmanuel98.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.github.fmanuel98.api.controllers.ClienteController;
import com.github.fmanuel98.api.controllers.CompraController;
import com.github.fmanuel98.api.controllers.ProdutoController;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class HateoasWebfluxLinks {

  public Link linkToProdutos(String rel) {
    return linkTo(ProdutoController.class).withRel(rel);
  }

  public Link linkToProdutos() {
    return linkToProdutos(IanaLinkRelations.SELF.value());
  }

  public Link linkToClientes(String rel) {
    return linkTo(ClienteController.class).withRel(rel);
  }

  public Link linkToClientes() {
    return linkToClientes(IanaLinkRelations.SELF.value());
  }

  public Link linkToCompras(String rel) {
    return linkTo(ClienteController.class).withRel(rel);
  }

  public Link linkToProdutoMaisVendidos() {
    return linkTo(methodOn(CompraController.class).produtosMaisVendidos()).withRel("produtos-mais-vendidos");
  }

  public Link linkToCompras() {
    return linkToCompras(IanaLinkRelations.SELF.value());
  }
}
