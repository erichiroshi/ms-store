package com.erichiroshi.store.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.erichiroshi.store.entities.Product;

@Component
@FeignClient(name = "ms-product", path = "/products")
public interface ProductFeignClient {

	@GetMapping
	ResponseEntity<List<Product>> findAll();

	@GetMapping(value = "/{id}")
	ResponseEntity<Product> findById(@PathVariable("id") Long id);
}
