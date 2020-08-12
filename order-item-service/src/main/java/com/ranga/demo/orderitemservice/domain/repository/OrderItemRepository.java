package com.ranga.demo.orderitemservice.domain.repository;

import com.ranga.demo.orderitemservice.domain.entity.EOrderItem;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRepository extends BaseRepository<EOrderItem,UUID>{

}
