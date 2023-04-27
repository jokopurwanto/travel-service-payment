package com.travel.payment.paymentdb.repository;

import com.travel.payment.paymentdb.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {
}
