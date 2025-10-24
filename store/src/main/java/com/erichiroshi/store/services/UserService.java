package com.erichiroshi.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erichiroshi.store.entities.User;
import com.erichiroshi.store.feignclients.UserFeignClient;
import com.erichiroshi.store.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserFeignClient client;

	public List<User> findAll() {
		return client.findAll().getBody();
	}

	public User findById(Long id) {
		try {
			return client.findById(id).getBody();
		} catch (Exception e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
