package com.spring.rest.systembankpayments.repositories;

import com.spring.rest.systembankpayments.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
