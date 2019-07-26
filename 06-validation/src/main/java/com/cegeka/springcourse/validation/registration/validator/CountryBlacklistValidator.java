package com.cegeka.springcourse.validation.registration.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryBlacklistValidator implements ConstraintValidator<CountryBlacklist, String> {

    @Override
    public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
        return !country.toUpperCase().equals("LICHTENSTEIN") && !country.toUpperCase().equals("RUSSIA");
    }
}
