package com.gmalheiro.paymentsystem.repository;

import com.gmalheiro.paymentsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByEmail(String email);

    User findByVerificationCode(String verificationCode);
}
