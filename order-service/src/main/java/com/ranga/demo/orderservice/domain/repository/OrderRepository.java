package com.ranga.demo.orderservice.domain.repository;

import com.ranga.demo.orderservice.domain.entity.EOrder;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends BaseRepository<EOrder,UUID>{

}
