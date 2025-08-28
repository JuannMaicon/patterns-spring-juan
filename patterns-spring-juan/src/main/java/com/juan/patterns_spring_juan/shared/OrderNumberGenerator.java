package com.juan.patterns_spring_juan.shared;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNumberGenerator {
    private static volatile OrderNumberGenerator INSTANCE;
    private final AtomicInteger counter = new AtomicInteger(0);
    private OrderNumberGenerator() { }

    public static OrderNumberGenerator getInstance() {
        if (INSTANCE == null) {
            synchronized (OrderNumberGenerator.class) {
                if (INSTANCE == null) INSTANCE = new OrderNumberGenerator();
            }
        }
        return INSTANCE;
    }

    public String next() {
        int seq = counter.incrementAndGet();
        return "ORD-" + LocalDate.now() + "-" + String.format("%04d", seq);
    }
}