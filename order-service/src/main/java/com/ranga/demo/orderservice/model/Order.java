package com.ranga.demo.orderservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder(toBuilder = true,builderClassName = "Builder")
@JsonDeserialize(builder = Order.Builder.class)
public class Order {

    private final String id;
    private final String customerName;
    private final ZonedDateTime creationDate;
    private final List<OrderItem> orderItemIds;
    private  final String shippingAddress;
    private final BigDecimal totalAmount;

    public Order copyAndOverride(List<OrderItem> orderItems){
        return Order.builder()
                .id(this.id)
                .customerName(this.getCustomerName())
                .shippingAddress(this.getShippingAddress())
                .totalAmount(this.getTotalAmount())
                .orderItemIds(orderItems)
                .creationDate(this.getCreationDate())
                .build();
    }
    @JsonPOJOBuilder(buildMethodName = "build",withPrefix = "")
    public static class Builder{

    }

}
