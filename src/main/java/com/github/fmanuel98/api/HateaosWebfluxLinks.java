package com.github.fmanuel98.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.github.fmanuel98.api.controllers.ProdutoController;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class HateaosWebfluxLinks {

  public Link linkToProdutos(String rel) {
    return linkTo(ProdutoController.class).withRel(rel);
  }

  public Link linkToProdutos() {
    return linkToProdutos(IanaLinkRelations.SELF.value());
  }
}
