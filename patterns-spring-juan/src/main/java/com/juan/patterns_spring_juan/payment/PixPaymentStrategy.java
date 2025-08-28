package com.juan.patterns_spring_juan.payment;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.util.UUID; // <<<<<< AQUI!

@Component
public class PixPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentType getType() {
        return PaymentType.PIX;
    }

    @Override
    public PaymentResult pay(Order order) {
        // simulação de pagamento aprovado com transação aleatória
        return new PaymentResult(true, "PIX-" + UUID.randomUUID());
    }
}
