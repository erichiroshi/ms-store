package com.erichiroshi.store.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.store.entities.Order;
import com.erichiroshi.store.entities.Payment;
import com.erichiroshi.store.services.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	private final OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping("/payments/{orderId}")
	public ResponseEntity<Payment> pay(@PathVariable("orderId") Long orderId, @RequestBody Payment payment) {
		payment.setOrderId(orderId);
		payment = service.pay(orderId, payment);
		return ResponseEntity.ok(payment);
	}

}
