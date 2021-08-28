package com.github.fmanuel98.api.assembler;

import com.github.fmanuel98.api.HateoasWebfluxLinks;
import com.github.fmanuel98.api.controllers.ClienteController;
import com.github.fmanuel98.api.model.ClienteModel;
import com.github.fmanuel98.domain.models.Cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClienteModelAssembler extends RepresentationModelAssemblerSupport<Cliente, ClienteModel> {
  @Autowired
  private ModelMapper mapper;
  @Autowired
  private HateoasWebfluxLinks webfluxLinks;

  public ClienteModelAssembler() {
    super(ClienteController.class, ClienteModel.class);
  }

  public ClienteModel toModel(Cliente cliente) {
    ClienteModel produtoModel = createModelWithId(cliente.getId(), cliente, "GET", "ACTIO");
    mapper.map(cliente, produtoModel);
    produtoModel.add(webfluxLinks.linkToProdutos("clientes"));
    return produtoModel;
  }

  @Override
  public CollectionModel<ClienteModel> toCollectionModel(Iterable<? extends Cliente> entities) {
    CollectionModel<ClienteModel> collectionModel = super.toCollectionModel(entities);
    collectionModel.add(webfluxLinks.linkToProdutos());
    return collectionModel;
  }

}
