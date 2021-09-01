package com.github.fmanuel98.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "compra")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;
  @OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
  private List<ItemCompra> itemsCompra;
  @ManyToOne(optional = false)
  private Cliente cliente;
  private BigDecimal total;
  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDate createdAt;
  @Column(nullable = false)
  @UpdateTimestamp
  private LocalDate updatedAt;

  @PreUpdate
  public void calcularTotal() {
    System.err.println(this.itemsCompra);
    var total = this.itemsCompra.stream().map(ItemCompra::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("compra total " + total);
    this.setTotal(total);
  }
}
