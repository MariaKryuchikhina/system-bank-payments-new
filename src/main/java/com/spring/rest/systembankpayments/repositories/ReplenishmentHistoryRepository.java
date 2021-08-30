package com.spring.rest.systembankpayments.repositories;

import com.spring.rest.systembankpayments.entity.ReplenishmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplenishmentHistoryRepository extends JpaRepository<ReplenishmentHistory, Long> {
}
