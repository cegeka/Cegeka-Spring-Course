package com.cegeka.springcourse.dependencyinjection;

import com.cegeka.springcourse.dependencyinjection.payment.PaymentClassForSpringScanning;
import com.cegeka.springcourse.dependencyinjection.vaccine.VaccineClassForSpringScanning;
import com.cegeka.springcourse.dependencyinjection.vaccine.ExternalMedicineComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {VaccineClassForSpringScanning.class, PaymentClassForSpringScanning.class})
public class SpringConfig {

    @Bean
    public ExternalMedicineComponent externalMedicineComponent() {
        return new ExternalMedicineComponent();
    }
}
