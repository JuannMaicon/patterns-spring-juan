package com.juan.patterns_spring_juan.payment;

import com.juan.patterns_spring_juan.domain.PaymentType;
import org.springframework.stereotype.Component;
import java.util.HashMap; import java.util.List; import java.util.Map;

@Component
public class PaymentStrategyFactory {
    private final Map<PaymentType, PaymentStrategy> strategies = new HashMap<>();
    public PaymentStrategyFactory(List<PaymentStrategy> list) {
        for (PaymentStrategy s : list) strategies.put(s.getType(), s);
    }
    public PaymentStrategy get(PaymentType type) {
        PaymentStrategy s = strategies.get(type);
        if (s == null) throw new IllegalArgumentException("Payment strategy not found: " + type);
        return s;
    }
}