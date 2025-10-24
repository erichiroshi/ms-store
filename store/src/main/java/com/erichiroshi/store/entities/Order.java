package com.erichiroshi.store.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.erichiroshi.store.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime moment;
	private Integer orderStatus;

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> items = new HashSet<>();

	private Long clientId;

	@Transient
	private User client;

	private Long paymentId;

	@Transient
	private Payment payment;

	public Order(Long id, LocalDateTime moment, OrderStatus orderStatus, Long clientId) {
		super();
		this.id = id;
		this.moment = moment;
		this.clientId = clientId;
		setOrderStatus(orderStatus);
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
	}
}
