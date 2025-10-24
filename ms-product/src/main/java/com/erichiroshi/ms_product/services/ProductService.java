package com.erichiroshi.ms_product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erichiroshi.ms_product.entities.Product;
import com.erichiroshi.ms_product.repositories.ProductRepository;
import com.erichiroshi.ms_product.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Product insert(Product product) {
		return repository.save(product);
	}

	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
