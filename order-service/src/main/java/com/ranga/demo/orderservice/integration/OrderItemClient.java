package com.ranga.demo.orderservice.integration;

import com.ranga.demo.orderservice.model.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name="ORDER-ITEM-SERVICE")
public interface OrderItemClient {
    /**
     * Create
     *
     * @param request
     * @return
     */
    @RequestMapping(
            value = "/v1/api/order-item",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItem create(@RequestBody OrderItem request);

    /**
     * Update
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(
            value = "/v1/api/order-item/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public OrderItem update(@PathVariable(value = "id") UUID id, @RequestBody OrderItem request) ;

    /**
     * Find All
     *
     * @return
     */
    @RequestMapping(
            value = "/v1/api/order-item",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItem> findAll();

    /**
     * Find One record
     *
     * @param id
     * @return
     */
    @RequestMapping(
            value = "/v1/api/order-item/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public OrderItem find(@PathVariable("id") UUID id);

    /**
     * Delete data
     *
     * @param id
     */
    @RequestMapping(
            value = "/v1/api/order-item/{id}",
            method = RequestMethod.DELETE
    )
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id);
}
