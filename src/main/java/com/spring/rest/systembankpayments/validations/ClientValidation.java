package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.entity.Client;

public interface ClientValidation {
    ValidationResult validate(ClientDto client);
}
