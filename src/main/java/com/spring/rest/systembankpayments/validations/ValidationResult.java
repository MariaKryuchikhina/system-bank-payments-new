package com.spring.rest.systembankpayments.validations;

import lombok.Value;

@Value
public class ValidationResult {
    boolean isValid;
    String errorMsg;

    public static ValidationResult valid(){
        return new ValidationResult(true, null);
    }

    public static ValidationResult invalid(String errorMsg){
        return new ValidationResult(false, errorMsg);
    }

    public boolean notValid(){
        return !isValid;
    }

}