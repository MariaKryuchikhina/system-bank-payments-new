package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;

import java.util.List;


public interface SimpleValidation {

   boolean validate(ClientDto client);
}
