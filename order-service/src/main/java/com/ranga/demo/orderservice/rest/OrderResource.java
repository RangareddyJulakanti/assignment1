package com.ranga.demo.orderservice.rest;

import com.ranga.demo.orderservice.model.Order;
import com.ranga.demo.orderservice.rest.curd.BaseResource;
import com.ranga.demo.orderservice.service.api.OrderOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Named;
import java.util.UUID;

@RestController("OrderResource")
@RequestMapping(value = "v1/api/order")
public class OrderResource extends BaseResource<Order,UUID> {
    @Named("orderTemplate")
    public OrderResource(OrderOperation orderOperation){
        super(orderOperation);
    }
}
