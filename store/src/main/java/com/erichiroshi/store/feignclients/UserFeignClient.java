package com.erichiroshi.store.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.erichiroshi.store.entities.User;

@Component
@FeignClient(name = "ms-user", path = "/users")
public interface UserFeignClient {

	@GetMapping
	ResponseEntity<List<User>> findAll();

	@GetMapping(value = "/{id}")
	ResponseEntity<User> findById(@PathVariable("id") Long id);
}
