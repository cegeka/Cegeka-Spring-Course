package com.cegeka.springcourse.dependencyinjection;

import org.springframework.web.bind.annotation.GetMapping;

public class PaymentController {

    @GetMapping(path = "/pay")
    public String pay() {
        return "Please pay";
    }
}
