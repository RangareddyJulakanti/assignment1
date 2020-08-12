package com.ranga.demo.orderitemservice.rest;

import com.ranga.demo.orderitemservice.model.OrderItem;
import com.ranga.demo.orderitemservice.rest.curd.BaseResource;
import com.ranga.demo.orderitemservice.service.api.OrderItemOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Named;
import java.util.UUID;

@RestController("OrderItemResource")
@RequestMapping(value = "v1/api/order-item")
public class OrderItemResource extends BaseResource<OrderItem,UUID> {


    @Named("orderItemTemplate")
    public OrderItemResource(OrderItemOperation orderItemOperation){
        super(orderItemOperation);
    }


}
