package com.spring.rest.systembankpayments.repositories;

import com.spring.rest.systembankpayments.entity.CreditAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {
}
