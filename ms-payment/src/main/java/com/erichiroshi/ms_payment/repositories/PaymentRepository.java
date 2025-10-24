package com.erichiroshi.ms_payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.ms_payment.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
