package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.validations.validator.PhoneNumberValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneNumberValidationStep extends ValidationStep<ClientDto>{

    private final ClientRepository clientRepository;

    @Override
    public ValidationResult verify(ClientDto clientDto){
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        if(!phoneNumberValidator.validatePhoneNumber(clientDto.getPhoneNumber())){
            return ValidationResult.invalid(String.format("PhoneNumber [%s] +7-897-566-7657", clientDto.getPhoneNumber()));
        }
        return checkNext(clientDto);
    }
}