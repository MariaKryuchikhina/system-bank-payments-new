package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.validations.validator.EmailValidator;
import com.spring.rest.systembankpayments.validations.validator.PhoneNumberValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
@Service
@Validated
@AllArgsConstructor
public class ClientValidationServiceImpl implements ClientValidationService {

    private final ClientRepository clientRepository;

    @Override
    public ValidationResult validate(ClientDto clientDto) {
        log.info("Проверка email");
        return new CommandConstraintsValidationStep()
                .linkWith(new PhoneNumberValidationStep(clientRepository))
                .linkWith(new EmailValidationStep(clientRepository))
                .verify(clientDto);
    }


    private static class CommandConstraintsValidationStep extends ValidationStep<ClientDto> {

        @Override
        public ValidationResult verify(ClientDto clientDto) {
            try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
                final Validator validator = validatorFactory.getValidator();
                final Set<ConstraintViolation<ClientDto>> constraintsViolations = validator.validate(clientDto);

                if (!(constraintsViolations).isEmpty()) {
                    return ValidationResult.invalid(constraintsViolations.iterator().next().getMessage());
                }
            }
            return checkNext(clientDto);
        }
    }

    @AllArgsConstructor
    private static class EmailValidationStep extends ValidationStep<ClientDto>{

        private final ClientRepository clientRepository;
//        private final ClientMapper clientMapper;

        @Override
        public ValidationResult verify(ClientDto clientDto){
            EmailValidator emailValidator = new EmailValidator();
            if(!emailValidator.validateEmail(clientDto.getEmail())){
                return ValidationResult.invalid(String.format("Email [%s] qwerty@gmail.com", clientDto.getEmail()));
            }
            return checkNext(clientDto);
        }
    }

    @AllArgsConstructor
    private static class PhoneNumberValidationStep extends ValidationStep<ClientDto>{

        private final ClientRepository clientRepository;
//        private final ClientMapper clientMapper;

        @Override
        public ValidationResult verify(ClientDto clientDto){
            PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
            if(!phoneNumberValidator.validatePhoneNumber(clientDto.getPhoneNumber())){
                return ValidationResult.invalid(String.format("PhoneNumber [%s] +7-897-566-7657", clientDto.getPhoneNumber()));
            }
            return checkNext(clientDto);
        }
    }
}
