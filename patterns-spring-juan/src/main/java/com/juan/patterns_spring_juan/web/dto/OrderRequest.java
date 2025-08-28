package com.juan.patterns_spring_juan.web.dto;

import com.juan.patterns_spring_juan.domain.PaymentType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

    @NotNull
    private PaymentType paymentType;   // PIX, CREDIT_CARD, BOLETO

    private String receiptFormat = "JSON"; // "JSON" (default) ou "CSV"

    @NotEmpty
    private List<ItemRequest> items = new ArrayList<>();

    public OrderRequest() { }

    // getters e setters
    public PaymentType getPaymentType() { return paymentType; }
    public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }

    public String getReceiptFormat() { return receiptFormat; }
    public void setReceiptFormat(String receiptFormat) { this.receiptFormat = receiptFormat; }

    public List<ItemRequest> getItems() { return items; }
    public void setItems(List<ItemRequest> items) { this.items = items; }
}
