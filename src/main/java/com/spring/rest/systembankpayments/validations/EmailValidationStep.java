package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.validations.validator.EmailValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailValidationStep extends ValidationStep<ClientDto>{
    private final ClientRepository clientRepository;

    @Override
    public ValidationResult verify(ClientDto clientDto){
        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validateEmail(clientDto.getEmail())){
            return ValidationResult.invalid(String.format("Email [%s] qwerty@gmail.com", clientDto.getEmail()));
        }
        return checkNext(clientDto);
    }
}
