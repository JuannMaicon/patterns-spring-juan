package com.juan.patterns_spring_juan.payment;

public class PaymentResult {
    private final boolean approved;
    private final String transactionId;

    public PaymentResult(boolean approved, String transactionId) {
        this.approved = approved;
        this.transactionId = transactionId;
    }
    public boolean isApproved() { return approved; }
    public String getTransactionId() { return transactionId; }
}