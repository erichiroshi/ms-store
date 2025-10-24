package com.erichiroshi.store.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erichiroshi.store.entities.Payment;

@Component
@FeignClient(name = "ms-payment", path = "/payments")
public interface PaymentFeignClient {

	@GetMapping
	ResponseEntity<List<Payment>> findAll();

	@GetMapping(value = "/{id}")
	ResponseEntity<Payment> findById(@PathVariable("id") Long id);

	@PutMapping("/{id}")
	public ResponseEntity<Payment> update(@PathVariable("id") Long id, @RequestBody Payment payment);

	@PostMapping
	public ResponseEntity<Payment> insert(@RequestBody Payment payment);
}
