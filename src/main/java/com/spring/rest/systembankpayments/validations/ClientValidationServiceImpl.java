package com.spring.rest.systembankpayments.validations;

import com.spring.rest.systembankpayments.dto.ClientDto;
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
public class ClientValidationServiceImpl implements ClientValidation {

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

}
