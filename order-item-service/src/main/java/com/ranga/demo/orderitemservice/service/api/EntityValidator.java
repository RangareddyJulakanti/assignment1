package com.ranga.demo.orderitemservice.service.api;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface EntityValidator<T> {

    Set<ConstraintViolation<T>> validate(T t);
}