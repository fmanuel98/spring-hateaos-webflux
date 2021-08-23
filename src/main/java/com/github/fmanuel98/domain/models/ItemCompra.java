package com.github.fmanuel98.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "item_compra")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCompra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
  @EqualsAndHashCode.Include
  private Produto produto;
  @ManyToOne(optional = false)
  private Compra compra;
  @Column(nullable = false, length = 54)
  private String nomeProduto;
  @Column(nullable = false)
  private BigDecimal precoProduto;
  @Column(nullable = false)
  private BigDecimal subTotal;
  @Column(nullable = false)
  private Integer quantidade;
  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDate createdAt;
  @Column(nullable = false)
  @UpdateTimestamp
  private LocalDate updatedAt;
}
