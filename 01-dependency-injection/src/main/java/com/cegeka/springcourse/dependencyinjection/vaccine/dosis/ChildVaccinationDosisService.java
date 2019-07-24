package com.cegeka.springcourse.dependencyinjection.vaccine.dosis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("child")
public class ChildVaccinationDosisService implements VaccinationDosisService {
    @Override
    public String determineVaccinationDosis() {
        return "0.5mg";
    }
}
