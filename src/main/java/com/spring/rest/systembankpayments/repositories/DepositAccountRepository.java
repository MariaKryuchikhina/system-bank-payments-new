package com.spring.rest.systembankpayments.repositories;

import com.spring.rest.systembankpayments.entity.DepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositAccountRepository extends JpaRepository<DepositAccount, Long> {
}
