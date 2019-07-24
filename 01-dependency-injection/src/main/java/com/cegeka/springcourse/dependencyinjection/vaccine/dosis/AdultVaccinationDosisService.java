package com.cegeka.springcourse.dependencyinjection.vaccine.dosis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("adult")
public class AdultVaccinationDosisService implements VaccinationDosisService {

    private int counter = 0;

    @Override
    public String determineVaccinationDosis() {
        System.out.println("Counter: "+ counter);
        counter++;
        return "1mg";
    }
}
