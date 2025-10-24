package com.erichiroshi.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erichiroshi.store.entities.Payment;
import com.erichiroshi.store.feignclients.PaymentFeignClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

	private final PaymentFeignClient client;

	public List<Payment> findAll() {
		return client.findAll().getBody();
	}

	public Payment findById(Long id) {
		try {
			return client.findById(id).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	public Payment pay(Payment payment) {
		payment = client.insert(payment).getBody();
		return payment;
	}
}
