package com.ranga.demo.orderitemservice.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "ORDER_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EOrderItem {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "CHAR(32)")
  private UUID uuid;

  @Column(name = "PRODUCT_CD")
  private String productCode;

  @Column(name = "PRODUCT_NAME")
  private String productName;

  @Column(name = "QUANTITY")
  private BigInteger quantity;

  @Column(name="PRICE")
  private BigDecimal price;
}
