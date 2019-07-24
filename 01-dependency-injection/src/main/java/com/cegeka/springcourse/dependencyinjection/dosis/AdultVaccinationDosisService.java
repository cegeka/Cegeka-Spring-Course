package com.cegeka.springcourse.dependencyinjection.dosis;

public class AdultVaccinationDosisService implements VaccinationDosisService {
    @Override
    public String determineVaccinationDosis() {
        return "1mg";
    }
}
