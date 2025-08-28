package com.juan.patterns_spring_juan.payment

import com.juan.patterns_spring_juan.domain.Order
import com.juan.patterns_spring_juan.domain.PaymentType
import org.springframework.stereotype.Component
import java.util.*


@Component
class BoletoPaymentStrategy : PaymentStrategy {
    override fun getType(): PaymentType {
        return PaymentType.BOLETO
    }

    override fun pay(order: Order?): PaymentResult {
        return PaymentResult(true, "BLT-" + UUID.randomUUID())
    }
}