package com.travel.payment.repository;

import com.travel.payment.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {
}
