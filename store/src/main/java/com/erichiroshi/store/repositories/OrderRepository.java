package com.erichiroshi.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.store.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
