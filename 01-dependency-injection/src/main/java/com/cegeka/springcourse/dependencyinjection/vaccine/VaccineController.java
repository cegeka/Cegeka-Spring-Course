package com.cegeka.springcourse.dependencyinjection.vaccine;

import com.cegeka.springcourse.dependencyinjection.vaccine.dosis.VaccinationDosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaccineController {

    //this works, purely based on the variable name == class name
//    @Autowired
//    private VaccinationDosisService adultVaccinationDosisService;
    @Autowired
    @Qualifier("adult")
    private VaccinationDosisService vaccinationDosisService;

    @Autowired
    private ExternalMedicineComponent externalMedicineComponent;

    @GetMapping("/vaccinate")
    public String helloVaccinatedWorld() {
        return externalMedicineComponent.applyVaccine() + vaccinationDosisService.determineVaccinationDosis();
    }
}
