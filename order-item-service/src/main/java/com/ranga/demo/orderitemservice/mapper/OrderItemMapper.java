package com.ranga.demo.orderitemservice.mapper;

import com.ranga.demo.orderitemservice.domain.entity.EOrderItem;
import com.ranga.demo.orderitemservice.model.OrderItem;

import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

public class OrderItemMapper {
    public static Function<EOrderItem, OrderItem> entity = item -> OrderItem.builder()
            .id(item.getUuid().toString())
            .productCode(item.getProductCode())
            .productName(item.getProductName())
            .quantity(item.getQuantity())
            .price(item.getPrice())
            .build();

    public static Function<OrderItem, EOrderItem> model = item -> new EOrderItem(
            Objects.nonNull(item.getId())?UUID.fromString(item.getId()):null,
            item.getProductCode(),
            item.getProductName(),
            item.getQuantity(),
            item.getPrice()
    );

    public static BiFunction<OrderItem, EOrderItem, EOrderItem> update = (updated, dbItem) -> {
        dbItem.setProductCode(updated.getProductCode());
        dbItem.setProductName(updated.getProductName());
        dbItem.setQuantity(updated.getQuantity());
        dbItem.setPrice(updated.getPrice());
        return dbItem;
    };
}
