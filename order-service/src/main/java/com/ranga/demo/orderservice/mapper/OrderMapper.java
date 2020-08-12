package com.ranga.demo.orderservice.mapper;

import com.ranga.demo.orderservice.domain.entity.EOrder;
import com.ranga.demo.orderservice.model.Order;

import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderMapper {
  public static Function<EOrder, Order> entity =
      entity ->
          Order.builder()
              .id(Objects.nonNull(entity.getUuid())?entity.getUuid().toString():null)
              .customerName(entity.getCustomerName())
              .shippingAddress(entity.getShippingAddress())
              .totalAmount(entity.getTotalPrice())
              .creationDate(entity.getCreationDate())
              .customerName(entity.getCustomerName())
              .build();

  public static Function<Order, EOrder> model =
      order ->
          new EOrder(
              Objects.nonNull(order.getId())?UUID.fromString(order.getId()):null,
              order.getCustomerName(),
              order.getShippingAddress(),
              order.getOrderItemIds().stream().map(item->item.getId()).collect(Collectors.joining(",")),
              order.getTotalAmount(),
              order.getCreationDate());

  public static BiFunction<Order, EOrder, EOrder> update =
      (updated, dbItem) -> {
        dbItem.setShippingAddress(updated.getShippingAddress());
        dbItem.setCustomerName(updated.getCustomerName());
        dbItem.setTotalPrice(updated.getTotalAmount());
        dbItem.setOrderItemIds(updated.getOrderItemIds().stream().map(item->item.getId()).collect(Collectors.joining(",")));
        return dbItem;
      };
}
