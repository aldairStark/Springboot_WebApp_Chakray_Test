package com.aldair.exam.springboot.webapp.springboot_web.Utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.aldair.exam.springboot.webapp.springboot_web.Utils.Phone_Validador;
@Documented
@Constraint(validatedBy = Phone_Validador.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidacionPhone {

    String message ()default "El formato de Telefono es incorrecto";

    Class<?>[]groups() default{};
    Class<? extends Payload>[] payload() default{};

}
