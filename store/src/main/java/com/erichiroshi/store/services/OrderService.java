package com.erichiroshi.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erichiroshi.store.entities.Order;
import com.erichiroshi.store.entities.Payment;
import com.erichiroshi.store.repositories.OrderRepository;
import com.erichiroshi.store.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {

	private final OrderRepository repository;
	private final UserService userService;
	private final ProductService productService;
	private final PaymentService paymentService;

	public List<Order> findAll() {
		List<Order> list = repository.findAll();
		list.forEach(x -> x.setClient(userService.findById(x.getClientId())));
		list.forEach(x -> x.setPayment(paymentService.findById(x.getPaymentId())));
		list.forEach(x -> x.getItems()
				.forEach(product -> product.setProduct(productService.findById(product.getProductId()))));
		return list;
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order order = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		order.setClient(userService.findById(order.getClientId()));
		order.setPayment(paymentService.findById(order.getPaymentId()));
		order.getItems().forEach(x -> x.setProduct(productService.findById(x.getProductId())));
		return order;
	}

	public Payment pay(Long orderId, Payment payment) {
		Order order = findById(orderId);
		payment = paymentService.pay(payment);
		order.setPaymentId(payment.getId());
		repository.save(order);
		return payment;
	}
}
