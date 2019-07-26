package com.cegeka.springcourse.validation.registration.validator;

import com.cegeka.springcourse.validation.registration.TeamRegistration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntourageBlacklistValidator implements ConstraintValidator<EntourageBlacklist, TeamRegistration> {


    @Override
    public boolean isValid(TeamRegistration teamRegistration, ConstraintValidatorContext constraintValidatorContext) {
        if ("NORTH-KOREA".equals(teamRegistration.getCountry().toUpperCase())
                || "PERU".equals(teamRegistration.getCountry().toUpperCase())) {
            return teamRegistration.getEntourageNames().isEmpty();
        }
        return true;
    }
}
