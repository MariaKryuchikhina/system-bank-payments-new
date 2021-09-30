package com.spring.rest.systembankpayments.validations.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidatorPattern {
    private Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_NUMBER = "^\\+\\d(-\\d{3}){2}-\\d{4}$";

    public PhoneNumberValidatorPattern() {
        pattern = Pattern.compile(PHONE_NUMBER, Pattern.CASE_INSENSITIVE);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
