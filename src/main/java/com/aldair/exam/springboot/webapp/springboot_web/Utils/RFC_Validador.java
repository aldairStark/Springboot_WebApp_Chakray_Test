package com.aldair.exam.springboot.webapp.springboot_web.Utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RFC_Validador implements  ConstraintValidator<ValidacionRFC, String> {

                                private static final String RegexRFC ="^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$";

                                @Override
                                public boolean isValid(String value, ConstraintValidatorContext context){
                                        if(value == null){
                                                return false;
                                        }

    return value.matches(RegexRFC);
}

}
