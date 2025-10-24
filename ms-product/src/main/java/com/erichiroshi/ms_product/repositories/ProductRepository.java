package com.erichiroshi.ms_product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.ms_product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
