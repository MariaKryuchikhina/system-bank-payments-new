package com.spring.rest.systembankpayments.validations;

public abstract class ValidationStep<T> {
    private ValidationStep<T> next;

    public ValidationStep<T> linkWith(ValidationStep<T> next){
        this.next = next;
        return next;
    }

    public abstract ValidationResult verify(T toValidate);

    protected ValidationResult checkNext(T toValidate){
        if (next == null){
            return ValidationResult.valid();
        }

        return next.checkNext(toValidate);
    }
}
