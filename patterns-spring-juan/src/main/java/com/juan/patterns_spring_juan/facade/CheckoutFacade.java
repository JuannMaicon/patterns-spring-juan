package com.juan.patterns_spring_juan.facade;

import com.juan.patterns_spring_juan.builder.OrderBuilder;
import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.OrderStatus;
import com.juan.patterns_spring_juan.payment.PaymentResult;
import com.juan.patterns_spring_juan.payment.PaymentStrategy;
import com.juan.patterns_spring_juan.payment.PaymentStrategyFactory;
import com.juan.patterns_spring_juan.receipt.CsvReceipt;
import com.juan.patterns_spring_juan.receipt.JsonReceipt;
import com.juan.patterns_spring_juan.receipt.ReceiptTemplate;
import com.juan.patterns_spring_juan.repository.OrderRepository;
import com.juan.patterns_spring_juan.shared.OrderNumberGenerator;
import com.juan.patterns_spring_juan.web.dto.ItemRequest;
import com.juan.patterns_spring_juan.web.dto.OrderRequest;
import com.juan.patterns_spring_juan.web.dto.OrderResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class CheckoutFacade {
    private final PaymentStrategyFactory factory;
    private final OrderRepository repository;

    public CheckoutFacade(PaymentStrategyFactory factory, OrderRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public OrderResponse placeOrder(OrderRequest req) {
        // Builder
        OrderBuilder builder = new OrderBuilder()
                .number(OrderNumberGenerator.getInstance().next())
                .payment(req.getPaymentType());

        BigDecimal total = BigDecimal.ZERO;
        for (ItemRequest it : req.getItems()) {
            builder.addItem(it.getSku(), it.getName(), it.getQuantity(), it.getPrice());
            total = total.add(it.getPrice().multiply(BigDecimal.valueOf(it.getQuantity())));
        }
        Order order = builder.total(total).build();

        // Strategy + Factory
        PaymentStrategy strategy = factory.get(req.getPaymentType());
        PaymentResult result = strategy.pay(order);
        order.setStatus(result.isApproved() ? OrderStatus.PAID : OrderStatus.FAILED);

        // Persist
        Order saved = repository.save(order);

        // Template Method (receipt)
        ReceiptTemplate receipt = "CSV".equalsIgnoreCase(req.getReceiptFormat())
                ? new CsvReceipt() : new JsonReceipt();
        String receiptText = receipt.generate(saved);

        return OrderResponse.from(saved, result.getTransactionId(), receiptText);
    }
}