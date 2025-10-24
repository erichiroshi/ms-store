package com.erichiroshi.store.entities;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	private final Set<Category> categories = new HashSet<>();
}
