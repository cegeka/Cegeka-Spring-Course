package com.cegeka.springcourse.axon;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverReportController {

    @PostMapping("/report")
    public void reportDriver(DriverReportDto driverReportDto) {
    }

    @PutMapping("/finepaid/{licenseplate}")
    public void payFine(@PathVariable("licenseplate") String licenseplate) {

    }
}
