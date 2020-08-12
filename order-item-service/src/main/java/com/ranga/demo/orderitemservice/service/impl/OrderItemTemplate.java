package com.ranga.demo.orderitemservice.service.impl;

import com.ranga.demo.orderitemservice.domain.entity.EOrderItem;
import com.ranga.demo.orderitemservice.domain.repository.OrderItemRepository;
import com.ranga.demo.orderitemservice.mapper.OrderItemMapper;
import com.ranga.demo.orderitemservice.model.OrderItem;
import com.ranga.demo.orderitemservice.service.api.OrderItemOperation;
import com.ranga.demo.orderitemservice.service.impl.curd.BaseCrudTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

@Named("orderItemTemplate")
public class OrderItemTemplate extends BaseCrudTemplate<OrderItem, EOrderItem,UUID> implements OrderItemOperation {
    OrderItemRepository orderItemRepository;
    @Inject
    public OrderItemTemplate(BaseEntityValidator<OrderItem> baseEntityValidator,
                             OrderItemRepository orderItemRepository) {
        super(orderItemRepository, OrderItemMapper.entity,  OrderItemMapper.model,  OrderItemMapper.update, baseEntityValidator);
        this.orderItemRepository = orderItemRepository;
    }
}
