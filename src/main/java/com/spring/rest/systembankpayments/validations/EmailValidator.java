package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailValidator implements SimpleValidation {

    @Override
    public boolean validate(ClientDto client) {
        return false;
    }
}
