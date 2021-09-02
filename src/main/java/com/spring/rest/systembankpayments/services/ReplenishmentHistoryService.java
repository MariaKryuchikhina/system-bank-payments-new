package com.spring.rest.systembankpayments.services;

import com.spring.rest.systembankpayments.entity.ReplenishmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplenishmentHistoryService extends CrudService<ReplenishmentHistory, Long> {
}
