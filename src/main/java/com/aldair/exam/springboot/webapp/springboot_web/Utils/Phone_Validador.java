package com.aldair.exam.springboot.webapp.springboot_web.Utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Phone_Validador implements ConstraintValidator<ValidacionPhone,String> {
private static final String REGEX_PHONE ="^(\\+?\\d{1,3})?\\d{10}$";
@Override
public boolean isValid(String value, ConstraintValidatorContext context){
    if(value == null){
        return false;
    }
    return value.matches(REGEX_PHONE);
}

}
