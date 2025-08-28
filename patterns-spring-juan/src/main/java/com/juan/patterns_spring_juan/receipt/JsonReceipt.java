package com.juan.patterns_spring_juan.receipt;

import com.juan.patterns_spring_juan.domain.Order;
import com.juan.patterns_spring_juan.domain.OrderItem;

public class JsonReceipt extends ReceiptTemplate {
    protected String header(Order o) {
        return "{\\\"order\\\":{\\\"number\\\":\\\"" + o.getOrderNumber() + "\\\",\\\"total\\\":" + o.getTotal() + ",";
    }
    protected String body(Order o) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\\"items\\\":[");
        for (int i=0;i<o.getItems().size();i++) {
            OrderItem it = o.getItems().get(i);
            sb.append("{\\\"sku\\\":\\\"").append(it.getSku()).append("\\\",")
                    .append("\\\"name\\\":\\\"").append(it.getName()).append("\\\",")
                    .append("\\\"qty\\\":").append(it.getQuantity()).append(",")
                    .append("\\\"price\\\":").append(it.getPrice()).append("}");
            if (i < o.getItems().size()-1) sb.append(",");
        }
        sb.append("],");
        return sb.toString();
    }
    protected String footer(Order o) { return "\\\"status\\\":\\\"" + o.getStatus() + "\\\"}}"; }
}