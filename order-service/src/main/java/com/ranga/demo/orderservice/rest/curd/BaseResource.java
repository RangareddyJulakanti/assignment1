package com.ranga.demo.orderservice.rest.curd;

import com.ranga.demo.orderservice.service.api.curd.BaseCrudOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


public abstract class BaseResource<L, ID extends Serializable> {
    protected BaseCrudOperations<L,ID> baseOperations;
    public BaseResource(BaseCrudOperations<L, ID> baseOperations) {
        this.baseOperations = baseOperations;
    }
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public L create(@RequestBody L request) {
        return baseOperations.create(request);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public L update(@PathVariable(value = "id") ID id, @RequestBody L request) {
        return baseOperations.update(id, request);
    }
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<L> findAll() {
        return baseOperations.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public L find(@PathVariable("id") ID id) {

        return baseOperations.find(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") ID id) {
        baseOperations.delete(id);
    }

}
