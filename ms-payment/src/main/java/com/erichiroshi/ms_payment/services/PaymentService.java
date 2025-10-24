package com.erichiroshi.ms_payment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erichiroshi.ms_payment.entities.Payment;
import com.erichiroshi.ms_payment.repositories.PaymentRepository;
import com.erichiroshi.ms_payment.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

	private final PaymentRepository repository;

	public List<Payment> findAll() {
		return repository.findAll();
	}

	public Payment findById(Long id) {
		Optional<Payment> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Payment insert(Payment category) {
		return repository.save(category);
	}

	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public Payment update(Long id, Payment payment) {
		Payment obj = findById(id);
		obj.setMoment(payment.getMoment());
		obj.setOrderId(payment.getOrderId());
		return obj;
	}
}
