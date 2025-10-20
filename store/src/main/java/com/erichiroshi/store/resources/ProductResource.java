package com.erichiroshi.store.resources;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductResource {

	private final Environment env;

	@GetMapping
	public ResponseEntity<String> getProducts() {
		log.info("port: " + env.getProperty("local.server.port"));
		return ResponseEntity.ok("Teste products\nport: " + env.getProperty("local.server.port"));
	}
}
