package com.cegeka.springcourse.dependencyinjection.dosis;

public class ChildVaccinationDosisService implements VaccinationDosisService {
    @Override
    public String determineVaccinationDosis() {
        return "0.5mg";
    }
}
