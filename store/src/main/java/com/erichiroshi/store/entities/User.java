package com.erichiroshi.store.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
}