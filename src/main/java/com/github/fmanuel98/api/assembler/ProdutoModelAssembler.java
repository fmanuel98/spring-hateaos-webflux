package com.github.fmanuel98.api.assembler;

import com.github.fmanuel98.api.HateoasWebfluxLinks;
import com.github.fmanuel98.api.controllers.ProdutoController;
import com.github.fmanuel98.api.model.ProdutoModel;
import com.github.fmanuel98.domain.models.Produto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProdutoModelAssembler extends RepresentationModelAssemblerSupport<Produto, ProdutoModel> {
  @Autowired
  private ModelMapper mapper;
  @Autowired
  private HateoasWebfluxLinks webfluxLinks;

  public ProdutoModelAssembler() {
    super(ProdutoController.class, ProdutoModel.class);
  }

  public ProdutoModel toModel(Produto produto) {
    ProdutoModel produtoModel = createModelWithId(produto.getId(), produto);
    mapper.map(produto, produtoModel);
    produtoModel.add(webfluxLinks.linkToProdutos("produtos"));
    return produtoModel;
  }

  @Override
  public CollectionModel<ProdutoModel> toCollectionModel(Iterable<? extends Produto> entities) {
    CollectionModel<ProdutoModel> collectionModel = super.toCollectionModel(entities);
    collectionModel.add(webfluxLinks.linkToProdutos());
    return collectionModel;
  }

}
