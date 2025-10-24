package com.erichiroshi.store.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Payment {

	private Long id;
	private LocalDateTime moment;
	
	private Long orderId;
}
