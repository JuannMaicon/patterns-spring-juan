package com.juan.patterns_spring_juan.builder;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.OrderItem;
import com.juan.patterns_spring_juan.domain.OrderStatus;
import com.juan.patterns_spring_juan.domain.PaymentType;

import java.math.BigDecimal; import java.time.OffsetDateTime;

public class OrderBuilder {
    private final Order order;
    public OrderBuilder() {
        order = new Order();
        order.setStatus(OrderStatus.NEW);
        order.setCreatedAt(OffsetDateTime.now());
    }
    public OrderBuilder number(String n) { order.setOrderNumber(n); return this; }
    public OrderBuilder payment(PaymentType t) { order.setPaymentType(t); return this; }
    public OrderBuilder addItem(String sku, String name, int qty, BigDecimal price) {
        OrderItem it = new OrderItem();
        it.setSku(sku); it.setName(name); it.setQuantity(qty); it.setPrice(price);
        order.addItem(it);
        return this;
    }
    public OrderBuilder total(BigDecimal total) { order.setTotal(total); return this; }
    public Order build() { return order; }
}