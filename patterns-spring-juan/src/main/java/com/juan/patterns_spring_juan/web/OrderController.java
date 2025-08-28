package com.juan.patterns_spring_juan.web;

import com.juan.patterns_spring_juan.facade.CheckoutFacade;
import com.juan.patterns_spring_juan.repository.OrderRepository;
import com.juan.patterns_spring_juan.web.dto.OrderRequest;
import com.juan.patterns_spring_juan.web.dto.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CheckoutFacade facade;
    private final OrderRepository repository;

    public OrderController(CheckoutFacade facade, OrderRepository repository) {
        this.facade = facade;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest request) {
        return ResponseEntity.ok(facade.placeOrder(request));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
