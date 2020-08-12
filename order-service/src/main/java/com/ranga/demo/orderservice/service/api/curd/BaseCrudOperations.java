package com.ranga.demo.orderservice.service.api.curd;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface BaseCrudOperations<M,ID> {

    M create(@Valid M request);
    M update(@NotNull ID id, @Valid M request);

    List<M> findAll();
    M find(@NotNull ID id);

    void delete(@NotNull ID id);
}