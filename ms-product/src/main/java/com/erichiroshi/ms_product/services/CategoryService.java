package com.erichiroshi.ms_product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erichiroshi.ms_product.entities.Category;
import com.erichiroshi.ms_product.repositories.CategoryRepository;
import com.erichiroshi.ms_product.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

	private final CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Category insert(Category category) {
		return repository.save(category);
	}

	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
