package com.bank.projectbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "portfolio")
public class Fond {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fond_name")
  private String fondName;

  @Column(name = "fond_amount")
  private int fondAmount;

  @Column(name = "fond_sum")
  private float fondSum;

  @Column(name = "fond_price")
  private float fondPrice;
}
