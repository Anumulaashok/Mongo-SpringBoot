package com.mongoDemo.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RollNumberValidator implements ConstraintValidator<Roll,String> {
    private String RollNumber;
    @Override
    public void initialize(Roll roll) {
        RollNumber=roll.Value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isValid;
        if(value!=null){
            isValid=value.startsWith(RollNumber);
        }
        else {
            return true;
        }
        return false;
    }
}
