package com.ranga.demo.orderitemservice.service.api;

import com.ranga.demo.orderitemservice.model.OrderItem;
import com.ranga.demo.orderitemservice.service.api.curd.BaseCrudOperations;

import java.util.UUID;

public interface OrderItemOperation extends BaseCrudOperations<OrderItem,UUID> {
}
