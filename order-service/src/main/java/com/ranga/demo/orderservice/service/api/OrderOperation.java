package com.ranga.demo.orderservice.service.api;

import com.ranga.demo.orderservice.model.Order;
import com.ranga.demo.orderservice.model.OrderItem;
import com.ranga.demo.orderservice.service.api.curd.BaseCrudOperations;

import java.util.UUID;

public interface OrderOperation extends BaseCrudOperations<Order,UUID> {
}
