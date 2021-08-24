package com.github.fmanuel98.api.controllers;

import com.github.fmanuel98.api.HateaosWebfluxLinks;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RootEntryPointController {
  private HateaosWebfluxLinks links;

  @GetMapping
  public RootEntryPointModel root() {
    var rootEntryPointModel = new RootEntryPointModel();
    rootEntryPointModel.add(links.linkToProdutos("produtos"));
    return rootEntryPointModel;
  }

  private static class RootEntryPointModel extends RepresentationModel<RootEntryPointModel> {
  }
}
