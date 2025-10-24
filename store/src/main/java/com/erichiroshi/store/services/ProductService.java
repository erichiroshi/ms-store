package com.erichiroshi.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erichiroshi.store.entities.Product;
import com.erichiroshi.store.feignclients.ProductFeignClient;
import com.erichiroshi.store.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductFeignClient client;

	public List<Product> findAll() {
		return client.findAll().getBody();
	}

	public Product findById(Long id) {
		try {
			return client.findById(id).getBody();
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
