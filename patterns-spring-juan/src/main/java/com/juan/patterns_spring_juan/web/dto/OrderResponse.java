package com.juan.patterns_spring_juan.web.dto;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.OrderStatus;
import com.juan.patterns_spring_juan.domain.PaymentType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OrderResponse {

    private Long id;
    private String orderNumber;
    private OrderStatus status;
    private PaymentType paymentType;
    private BigDecimal total;
    private OffsetDateTime createdAt;
    private String transactionId;
    private String receipt; // texto gerado (JSON ou CSV)

    public OrderResponse() { }

    public static OrderResponse from(Order o, String txId, String receipt) {
        OrderResponse r = new OrderResponse();
        r.id = o.getId();
        r.orderNumber = o.getOrderNumber();
        r.status = o.getStatus();
        r.paymentType = o.getPaymentType();
        r.total = o.getTotal();
        r.createdAt = o.getCreatedAt();
        r.transactionId = txId;
        r.receipt = receipt;
        return r;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public PaymentType getPaymentType() { return paymentType; }
    public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getReceipt() { return receipt; }
    public void setReceipt(String receipt) { this.receipt = receipt; }
}
