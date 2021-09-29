package com.spring.rest.systembankpayments.validations.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    public EmailValidator(){
        pattern = Pattern.compile(EMAIL, Pattern.CASE_INSENSITIVE);
    }

    public boolean validateEmail(String email){
        matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
