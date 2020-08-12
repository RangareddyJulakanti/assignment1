package com.ranga.demo.orderservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ORDER_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EOrder {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(32)")
    private UUID uuid;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="SHIPPING_ADDRESS")
    private String  shippingAddress;

    @Column(name="ORDER_ITEM_IDS")
    private String orderItemIds;

    @Column(name="TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name="ORDER_DATE")
    @CreationTimestamp
    private ZonedDateTime creationDate;
}
