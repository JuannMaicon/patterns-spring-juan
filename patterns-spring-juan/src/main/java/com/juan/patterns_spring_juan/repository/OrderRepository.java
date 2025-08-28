package com.juan.patterns_spring_juan.repository;

import com.juan.patterns_spring_juan.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
