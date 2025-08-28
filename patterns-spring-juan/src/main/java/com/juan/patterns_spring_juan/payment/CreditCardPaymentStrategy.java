package com.juan.patterns_spring_juan.payment;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    public PaymentType getType() { return PaymentType.CREDIT_CARD; }
    public PaymentResult pay(Order order) {
        return new PaymentResult(true, "CC-" + UUID.randomUUID());
    }
}