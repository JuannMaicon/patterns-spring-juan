package com.juan.patterns_spring_juan.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemRequest {

    @NotBlank
    private String sku;

    @NotBlank
    private String name;

    @NotNull @Min(1)
    private Integer quantity;

    @NotNull
    private BigDecimal price;

    public ItemRequest() { }

    // getters e setters
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
