package com.mongoDemo.demo.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value ={ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.CONSTRUCTOR})
@Constraint(validatedBy = RollNumberValidator.class)
public @interface  Roll {
    public String Value() default "smart";
    public String message() default "Roll Number Must start with smart";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] Payload() default {};


}
