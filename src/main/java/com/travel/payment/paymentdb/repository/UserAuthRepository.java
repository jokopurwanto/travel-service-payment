package com.travel.payment.paymentdb.repository;

import com.travel.payment.paymentdb.model.UserAuthModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuthModel, Integer> {
    UserAuthModel findByUsername(String username);
}
