package com.spring.rest.systembankpayments.validations.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorPattern {

    private static final String EMAIL = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    public EmailValidatorPattern(){
        pattern = Pattern.compile(EMAIL, Pattern.CASE_INSENSITIVE);
    }

    public boolean validateEmail(String email){
        matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
