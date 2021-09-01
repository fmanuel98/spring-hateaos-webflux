package com.github.fmanuel98.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
  @ManyToOne(optional = false, cascade = CascadeType.MERGE)
  @EqualsAndHashCode.Include
  private Produto produto;
  @ManyToOne(optional = false, cascade = { CascadeType.MERGE })
  private Compra compra;
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

  @PostLoad
  @PrePersist
  @PreUpdate
  public void calcularSubTotal() {
    var subTotal = this.precoProduto.multiply(BigDecimal.valueOf(this.quantidade));
    this.setSubTotal(subTotal);
  }
}
