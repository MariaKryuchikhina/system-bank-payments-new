package com.spring.rest.systembankpayments.validations.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_NUMBER = "^\\+\\d(-\\d{3}){2}-\\d{4}$";

    public PhoneNumberValidator() {
        pattern = Pattern.compile(PHONE_NUMBER, Pattern.CASE_INSENSITIVE);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
