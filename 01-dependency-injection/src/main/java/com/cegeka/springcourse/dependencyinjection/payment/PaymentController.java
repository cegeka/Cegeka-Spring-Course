package com.cegeka.springcourse.dependencyinjection.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping(path = "/pay")
    public String pay() {
        return "Please pay";
    }
}
