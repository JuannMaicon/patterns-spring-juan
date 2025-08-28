package com.juan.patterns_spring_juan.receipt;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.OrderItem;

public class CsvReceipt extends ReceiptTemplate {
    protected String header(Order o) { return "ORDER;" + o.getOrderNumber() + ";TOTAL;" + o.getTotal(); }
    protected String body(Order o) {
        StringBuilder sb = new StringBuilder("SKU;NAME;QTY;PRICE\n");
        for (OrderItem it : o.getItems())
            sb.append(it.getSku()).append(";").append(it.getName()).append(";")
                    .append(it.getQuantity()).append(";").append(it.getPrice()).append("\n");
        return sb.toString();
    }
    protected String footer(Order o) { return "STATUS;" + o.getStatus(); }
}