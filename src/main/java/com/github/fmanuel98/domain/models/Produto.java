package com.github.fmanuel98.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "produto", uniqueConstraints = @UniqueConstraint(columnNames = { "nome" }))
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;
  @Column(nullable = false, length = 54)
  private String nome;
  @Column(nullable = false)
  private BigDecimal preco;
  @Column(nullable = false)
  private Integer quantidade;
  @Column(nullable = false)
  private LocalDate dataExpiracao;
  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDate createdAt;
  @Column(nullable = false)
  @UpdateTimestamp
  private LocalDate updatedAt;
}
