package com.ranga.demo.orderservice.service.impl;

import com.ranga.demo.orderservice.domain.entity.EOrder;
import com.ranga.demo.orderservice.domain.repository.OrderRepository;
import com.ranga.demo.orderservice.exception.InValidOrderValueException;
import com.ranga.demo.orderservice.integration.OrderItemClient;
import com.ranga.demo.orderservice.mapper.OrderMapper;
import com.ranga.demo.orderservice.model.Order;
import com.ranga.demo.orderservice.model.OrderItem;
import com.ranga.demo.orderservice.service.api.OrderOperation;
import com.ranga.demo.orderservice.service.impl.curd.BaseCrudTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Named("orderTemplate")
public class OrderTemplate extends BaseCrudTemplate<Order, EOrder,UUID> implements OrderOperation {
    OrderRepository orderRepository;
    OrderItemClient orderItemClient;
    @Inject
    public OrderTemplate(BaseEntityValidator<Order> baseEntityValidator,
                         OrderRepository orderRepository,OrderItemClient orderItemClient) {
        super(orderRepository, OrderMapper.entity,  OrderMapper.model,  OrderMapper.update, baseEntityValidator);
        this.orderRepository = orderRepository;
        this.orderItemClient = orderItemClient;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order create(@Valid Order request) {
        Map<String,BigDecimal> orderItemTotalPriceById=new HashMap<>();
        List<OrderItem> orderItems=new ArrayList<>();
        //save Order Items
        request.getOrderItemIds().forEach(item->{
            OrderItem savedItem=orderItemClient.create(item);
            orderItems.add(savedItem);
            orderItemTotalPriceById.put(savedItem.getId(), savedItem.getPrice().multiply(new BigDecimal(savedItem.getQuantity())));
        });

        //Validation
        Double calcTotalItemsValue=orderItemTotalPriceById.entrySet().stream().mapToDouble(e->e.getValue().doubleValue()).sum();
        Double orderValue=request.getTotalAmount().doubleValue();
        if(!calcTotalItemsValue.equals(orderValue)){
            throw new InValidOrderValueException("Invalid totalPrice="+orderValue+" It should be = "+calcTotalItemsValue);
        }
        EOrder entity = entityMapper.apply(request);
        entity.setOrderItemIds(orderItemTotalPriceById.entrySet().stream().map(id->id.getKey()).collect(Collectors.joining(",")));
        entity = baseRepository.save(entity);
        Order order= modelMapper.apply(entity);
        return order.copyAndOverride(orderItems);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Order find(@NotNull UUID id) {
         EOrder entity = findOne(id);
         List<String> orderItemIds=Arrays.asList(entity.getOrderItemIds().split(","));
         List<OrderItem> orderItems=orderItemIds.stream().map(itemId->orderItemClient.find(UUID.fromString(itemId))).collect(Collectors.toList());
         Order existingOrder= modelMapper.apply(entity);
         return existingOrder.copyAndOverride(orderItems);
    }
}
