package com.spring.rest.systembankpayments.repositories;

import com.spring.rest.systembankpayments.entity.MainAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainAccountRepository extends JpaRepository<MainAccount, Long> {
}
