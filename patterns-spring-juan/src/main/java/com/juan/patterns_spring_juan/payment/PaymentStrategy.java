package com.juan.patterns_spring_juan.payment;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.PaymentType;

public interface PaymentStrategy {
    PaymentType getType();
    PaymentResult pay(Order order);
}