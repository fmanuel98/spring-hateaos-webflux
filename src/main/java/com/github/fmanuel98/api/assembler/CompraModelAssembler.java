package com.github.fmanuel98.api.assembler;

import com.github.fmanuel98.api.HateoasWebfluxLinks;
import com.github.fmanuel98.api.controllers.CompraController;
import com.github.fmanuel98.api.model.CompraModel;
import com.github.fmanuel98.domain.models.Compra;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CompraModelAssembler extends RepresentationModelAssemblerSupport<Compra, CompraModel> {
  @Autowired
  private ModelMapper mapper;
  @Autowired
  private HateoasWebfluxLinks webfluxLinks;

  public CompraModelAssembler() {
    super(CompraController.class, CompraModel.class);
  }

  public CompraModel toModel(Compra compra) {
    CompraModel compraModel = createModelWithId(compra.getId(), compra);
    mapper.map(compra, compraModel);
    compraModel.add(webfluxLinks.linkToCompras("compras"));
    return compraModel;
  }

  @Override
  public CollectionModel<CompraModel> toCollectionModel(Iterable<? extends Compra> entities) {
    CollectionModel<CompraModel> collectionModel = super.toCollectionModel(entities);
    collectionModel.add(webfluxLinks.linkToCompras());
    return collectionModel;
  }

}
