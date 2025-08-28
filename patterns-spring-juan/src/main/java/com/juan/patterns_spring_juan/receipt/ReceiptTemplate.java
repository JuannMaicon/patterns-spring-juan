package com.juan.patterns_spring_juan.receipt;

import com.juan.patterns_spring_juan.domain.Order;

public abstract class ReceiptTemplate {
    public final String generate(Order order) {
        return header(order) + System.lineSeparator()
                + body(order) + System.lineSeparator()
                + footer(order);
    }
    protected abstract String header(Order order);
    protected abstract String body(Order order);
    protected abstract String footer(Order order);
}