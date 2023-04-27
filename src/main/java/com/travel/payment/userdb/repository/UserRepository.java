package com.travel.payment.userdb.repository;

import com.travel.payment.userdb.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
