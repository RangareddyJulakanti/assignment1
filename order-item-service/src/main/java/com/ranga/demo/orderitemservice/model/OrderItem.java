package com.ranga.demo.orderitemservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = OrderItem.Builder.class)
@Getter
public class OrderItem {

  private final String id;
  private final String productCode;
  private final String productName;
  private final BigInteger quantity;
  private final BigDecimal price;

  @JsonPOJOBuilder(withPrefix = "", buildMethodName = "build")
  public static class Builder {}
}
